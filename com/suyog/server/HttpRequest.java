package com.suyog.server;

public class HttpRequest {
	public String filename;

	public HttpRequest(String request) {
		
		//splits all lines from the request
		String lines[] = request.split("\n");
		System.out.println(lines[0]);
		//takes second string from first line which is basically the filename requested.
		lines = lines[0].split(" ");
		
		filename = lines[1];
		//System.out.println(filename);
		
	}
}
