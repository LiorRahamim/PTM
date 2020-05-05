package boot;

import server.MyTestClientHandler;
import server.MySerialServer;
import server.Server;

public class Run {

	public static void main(String[] args)  throws Exception{
		Server s=new MySerialServer(Integer.parseInt(args[0]));
		s.start(new MyTestClientHandler());
		Thread.sleep(60*1000);
		s.stop();
	}

}


