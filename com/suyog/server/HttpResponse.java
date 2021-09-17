package com.suyog.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HttpResponse{
	HttpRequest req;
	String response;
	String root = "/home/suyog/workspace/myServer/data";
	
		public HttpResponse(HttpRequest request){
			req = request;
			File f = new File(root + req.filename);
			
			try {
				
				response = "HTTP/1.0 200\r\n";
				response += "SUYOG\r\n";
				response += "Content-Type: text/html \r\n";
				response += "Connectin close \r\n";
				response += "Content-Length: "+ f.length() + "\r\n";
				response += "\r\n";
				
				FileInputStream fis = new FileInputStream(f);
				int s;
				while((s=fis.read()) != -1){
					response += (char) s;				 
				}
				fis.close();
			} 
			catch (FileNotFoundException e) {			
				//404 if file not found
				response = response.replace("200", "400");
				response = "<html><body><h1>File Not found: 404 Error</h1></body></html>";
			}
			catch(Exception e){
				//500 internal server error
				response = response.replace("200", "500");
			}	
			//System.out.println(response);
	}
}