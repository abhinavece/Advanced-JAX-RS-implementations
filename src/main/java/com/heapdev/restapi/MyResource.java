package com.heapdev.restapi;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MyResource {
	
	/**
	 * For Singleton class, instance is created before the request is made. So the queryParam and pathParam will throw the error.
	 */
	
	/**
	 * For 
	 */
	
	@PathParam("pathParam") private String pathParam;
	@QueryParam("queryParam") private String queryParam;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return " PathParam: "+pathParam+ ", queryParam: "+queryParam;
	}

}
