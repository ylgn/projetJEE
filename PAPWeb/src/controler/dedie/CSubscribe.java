package controler.dedie;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PAP.SESSION.IApplication;

public class CSubscribe implements ICTreatment {
	IApplication app;
	String name,email,pass,city;
	public CSubscribe() throws NamingException {
		Context ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
		
	}
	
	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//We get request's attributes 
		
		this.name = (String) request.getAttribute("name");
		this.email = (String) request.getAttribute("email");
		this.pass = (String) request.getAttribute("pass");
		this.city = (String) request.getAttribute("city");	
		//We ask glassfish for suscribe the adherent
		app.subscribe(name, email, pass, city);
		//
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/subscribeAns.jsp");
		dispatch.forward(request, response);
	}

}
