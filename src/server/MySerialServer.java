package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MySerialServer implements Server{
	

	  private int port;
	  private volatile boolean stop;

	  public MySerialServer(int port) {
	    this.port=port;
	    stop=false;
	  }
	
	
	private void runServer(ClientHandler ch){
		try{
		  ServerSocket server=new ServerSocket(port);
		  server.setSoTimeout(1000);
		  while(!stop){
		    try{
		      Socket aClient=server.accept(); // blocking call
			try {

		           ch.handleClient(aClient.getInputStream(), aClient.getOutputStream());
		           
		           aClient.close();

		         } catch (IOException e) {/*...*/}
		    }catch(SocketTimeoutException e) {/*...*/}
		  }
		  server.close(); 
		}catch(Exception e){
			/*...*/
		}
	}
	

	@Override
	public void start(ClientHandler ch) {
		new Thread(()->runServer(ch)).start();
	}

	@Override
	public void stop() {
		stop=true;
	}

	
}
