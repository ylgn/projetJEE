package appli;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import PAP.SESSION.IApplication;


public class app {
	private static IApplication app;
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		/* Context ctx;
		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
			System.out.println("app " + app);
			app.subscribe("test", "test", "test", "Poissy");
			
			
			System.out.println("succed");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Client clientRest = ClientBuilder.newClient();
		WebTarget ressource = clientRest.target("http://51.68.226.60:8080/API/rest");
		ressource = ressource.path("magasin/produits");
		Invocation.Builder httpQuery = ressource.request();
		
		
		
		
		
		
		
	}
	
}
