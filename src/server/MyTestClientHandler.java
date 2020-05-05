package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MyTestClientHandler implements ClientHandler {

	CacheManager cm;
	Solver<String,String> solver;
	
	public MyTestClientHandler() {
		cm=new FileCacheManager();
		solver=(s)->new StringBuilder(s).reverse().toString();
	}
	
	@Override
	public void handleClient(InputStream in, OutputStream out) {
		try{
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(in));
			PrintWriter outToClient=new PrintWriter(out);
			String line;
			while(!(line=inFromClient.readLine()).equals("end")){
				String sol=cm.getSolution(line);
				if(sol==null){
					sol=solver.solve(line);
					cm.saveSolution(line, sol);
				}
				outToClient.println(sol);
				outToClient.flush();
			}
			inFromClient.close();
			outToClient.close();
		}catch(IOException e){}
	}

}
