package com.suyog.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	ServerSocket serverSocket;
	public static void main(String[] args) throws Exception{
		new Main().runServer();
	}
	public void runServer() throws Exception{
		System.out.println("Server is started..");
		serverSocket = new ServerSocket(8080);//port number at which server is running
		acceptRequest();
	}
	
	private void acceptRequest() throws Exception{
		while(true){
			//connection from client is accepted which is through socket. 
			Socket s = serverSocket.accept();
			ConnectionHandler ch = new ConnectionHandler(s);
			ch.start();
		}
	}

}
