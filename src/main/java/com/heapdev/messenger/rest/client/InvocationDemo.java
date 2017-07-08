package com.heapdev.messenger.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.heapdev.messenger.model.Message;

public class InvocationDemo {
	
	public static void main(String[] args) throws Exception {
		
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestForMessageByYear(2015);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
	}

	private Invocation prepareRequestForMessageByYear(int year) throws CustomException {
		
		Client client = ClientBuilder.newClient();
		return client.target("http://localhost:8080/messenger/restapi/")
									.path("messages")
									.queryParam("year", year)
									.request(MediaType.APPLICATION_JSON)
									.buildGet();
//									?year={year}		
	}
}
