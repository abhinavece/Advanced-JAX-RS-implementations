package com.heapdev.restapi;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
public class DateResource {
	
//	@PathParam("dateString") private MyDate myDate;
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getRequestedDate(@PathParam("dateString") MyDate myDate){
//		return "Date is: "+myDate.toString();
//	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getRequestedDate(@PathParam("dateString") MyDate myDate){
		return Calendar.getInstance().getTime();
	}
}
