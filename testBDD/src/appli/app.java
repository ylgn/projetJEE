package appli;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import PAP.SESSION.IApplication;


public class app {
	private static IApplication app;
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		Context ctx;
		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
			System.out.println("app " + app);
			app.subscribe("test", "testee", "testezez", "Poissy");
			
			
			System.out.println("succed");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//WebTarget ressource = clientRest.target("http://51.68.226.60:8080/API/rest");
		//ressource = ressource.path("magasin/produits");
		//Invocation.Builder httpQuery = ressource.request();
		
		
		
		
		
		
		
	}
	
}
