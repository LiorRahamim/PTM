package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCacheManager implements CacheManager {

	@Override
	public String getSolution(String problem) {
		File f=new File(problem+".sol");
		if(!f.exists())
			return null;
		
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(problem+".sol"));
			String line=in.readLine();
			in.close();
			return line;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveSolution(String problem, String solution) {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(problem+".sol"));
			out.println(solution);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
