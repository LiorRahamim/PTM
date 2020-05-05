package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// this is just a communication tester, not a real solver
public class MyClientHandler implements ClientHandler{

	@Override
	public void handleClient(InputStream in, OutputStream out) {
		try {
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(in));
			String line;
			while(!(line=inFromClient.readLine()).equals("end")){
				// use lines to create a searchable and solve it
			}
			inFromClient.readLine(); // start
			inFromClient.readLine(); // end
			
			PrintWriter outToClient=new PrintWriter(out);
			// an example of solution:
			outToClient.println("Right,Down,Right,Down,Right,Down");
			outToClient.close();
			inFromClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
