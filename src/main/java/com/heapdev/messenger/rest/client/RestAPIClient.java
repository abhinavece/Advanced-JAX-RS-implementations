package com.heapdev.messenger.rest.client;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.heapdev.messenger.model.Message;

public class RestAPIClient {

	public static void main(String[] args) {
		
		/**
		 * Method 1
		 */
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8080/messenger/restapi/messages/1");
//		Builder builder = target.request(MediaType.APPLICATION_JSON);
//		Response response = builder.get();
//
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getAuthor());

		
		/**
		 * Method 2
		 */
//		Client client = ClientBuilder.newClient();
//		Message message = client.target("http://localhost:8080/messenger/restapi/messages/1")
//				.request(MediaType.APPLICATION_JSON)
//				.get(Message.class);
//		
//		System.out.println(message.getAuthor());

		
		/**
		 * Method 3
		 */
//		Client client = ClientBuilder.newClient();
//		String message = client.target("http://localhost:8080/messenger/restapi/messages/1")
//				.request(MediaType.APPLICATION_JSON)
//				.get(String.class);
//		System.out.println(message);

		
		/**
		 * Method 4
		 */
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/restapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		/**
		 * for GET method
		 */
		Message message1 = singleMessageTarget
											.resolveTemplate("messageId", "7")
											.request(MediaType.APPLICATION_JSON)
											.get(Message.class);
		System.out.println(message1.getMessage());
		
		/**
		 * for GET method
		 */
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "5")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(message2.getMessage());
		
		/**
		 * for POST method
		 */
		Message newMessage = new Message(8L, "This is Eighth Message", "abhnavece");
		Response postResponse = messagesTarget
											.request()
											.post(Entity.json(newMessage));
		if(postResponse.getStatus() != 201){
			System.out.println("Error handling code here");
		}
		Message createdMessage = postResponse.readEntity(Message.class);
		
		System.out.println(createdMessage.getMessage());
		
		Message updateMessage = new Message(8L, "Did I changed this ???", "abhinavece");
		Response updateResponse = singleMessageTarget
						.resolveTemplate("messageId", 8L)
						.request()
						.put(Entity.json(updateMessage));
		
		System.out.println(updateResponse.readEntity(Message.class));
		

	}
	

}
