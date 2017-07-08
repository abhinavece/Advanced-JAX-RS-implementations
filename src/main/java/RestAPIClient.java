import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.heapdev.messenger.model.Message;

public class RestAPIClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/messenger/restapi/messages/1");
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();

		Message message = response.readEntity(Message.class);
		System.out.println(message.getAuthor());

	}

}
