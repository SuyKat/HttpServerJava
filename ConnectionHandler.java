package myServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//this class accepts all the connections which contains the requests
public class ConnectionHandler extends Thread{//class becomes a thread
	Socket s;
	PrintWriter output;
	BufferedReader input;
	//constructor accepting the socket
	public ConnectionHandler(Socket s) throws IOException{
		this.s = s;
		output = new PrintWriter(s.getOutputStream()); //for response output
		input = new BufferedReader(new InputStreamReader(s.getInputStream()));//for request input
	}	
	
	//run method automatically starts when we start thread
	//this method takes the request and gives response 
	@Override
		public void run() {
			try{
				String reqS = "";
			
				//from input we read our request in
			
				while(input.ready() || reqS.length()==0){
					reqS += (char) input.read();
				}
				System.out.println(reqS);
			
				HttpRequest req = new HttpRequest(reqS);
				HttpResponse res = new HttpResponse(req);
				output.write(res.response.toCharArray());
				
				output.close();
				input.close();
				s.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
