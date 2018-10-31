package appli;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import PAP.MODEL.ObjectPAP;
import PAP.MODEL.UserPAP;
import PAP.SESSION.IApplication;


public class app {
	private static IApplication app;
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		Context ctx;
		UserPAP testMan = null;
		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
			System.out.println("app " + app);
			
			/*
			app.subscribe("Yannis", "yannis.le-guen@hotmail.fr","test", "Poissy");
			app.subscribe("Yannis", "axelleguen@hotmail.fr","test", "Poissy");
			app.subscribe("léa", "leaboris@gmail.com","test", "Aureille");
			app.subscribe("virginie","virginie.le-guen@wanadoo.fr","test", "Poissy");
			app.subscribe("aurélie","floli@hotmail.fr","test", "Aureille");
			app.subscribe("serge", "s.widerowski@sfr.fr", "test","La Teste");
			app.subscribe("martine","sm.widerowski@orange.fr", "test","La Teste");
			app.subscribe("anna", "testeanna","test", "Aureille");
			app.subscribe("romy","testromy", "test","Aureille");
			app.subscribe("raymonde","testnounou", "test","Poissy");
			*/
			
			testMan = app.getUserByMail("yannis.le-guen@hotmail.fr");
			System.out.println(testMan.getMail());
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//WebTarget ressource = clientRest.target("http://51.68.226.60:8080/API/rest");
		//ressource = ressource.path("magasin/produits");
		//Invocation.Builder httpQuery = ressource.request();
		
		/*
		Client clientRest = ClientBuilder.newClient();
		WebTarget ressource = clientRest.target("http://51.68.226.60:8080/PAPFunctions/rest");
		ressource = ressource.path("resources/objects");
		Invocation.Builder httpQuery = ressource.request();
		
		Entity<ObjectPAP> monEntity = Entity.json(new ObjectPAP(testMan, "ok", "ok", 12, "ok"));
		ObjectPAP prodCree = httpQuery.accept(MediaType.APPLICATION_JSON).post(monEntity,ObjectPAP.class);
		
		*/
		
		
		
		
	}
	
}
