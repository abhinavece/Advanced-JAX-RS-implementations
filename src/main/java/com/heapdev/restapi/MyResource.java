package com.heapdev.restapi;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Singleton
public class MyResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		count = count+1;
		return "Total number of request is: "+ count;
	}

}
