package appli;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import PAP.MODEL.ObjectPAP;
import PAP.MODEL.UserPAP;

public class clientwebservice {

	public static void main(String[] args) {
		Client clientRest = ClientBuilder.newClient();
		WebTarget ressource = clientRest.target("http://51.68.226.60:8080/PAPFunctions/rest");
		ressource = ressource.path("resources/objects");
		Invocation.Builder httpQuery = ressource.request();
	
		Entity<ObjectPAP> monEntity = Entity.json(new ObjectPAP(new UserPAP("mail", "city", 
				"name", "pass"), "Porshe", "Panamera", 140000, "Poissy"));
		ObjectPAP prodCree = httpQuery.accept(MediaType.APPLICATION_JSON).post(monEntity,ObjectPAP.class);

	}

}
