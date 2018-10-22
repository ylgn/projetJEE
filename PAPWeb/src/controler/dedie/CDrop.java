package controler.dedie;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PAP.SESSION.IApplication;

public class CDrop implements ICTreatment {
	IApplication app;
	Boolean allowed;
	String name,description;
	double price;
	HttpSession session;
	public CDrop() throws NamingException {
		Context ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
		
	}
	
	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//We check if the user is allowed to buy object
		//Eli code moi cet API Please :)
		
		
	}

}
