package appli;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import PAP.SESSION.IApplication;


public class app {
	private static IApplication app;
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Context ctx;
		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
			System.out.println("app " + app);
			app.subscribe("LE GUEN", "virginie.le-guen@wanadoo.fr", "pass", "Poissy");
		
			System.out.println("succed");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
