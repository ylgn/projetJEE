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

public class CConnect implements ICTreatment {
	Context ctx;
	IApplication app;
	String name,email;
	
	public CConnect() throws NamingException {
		ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
		
		
	}
	
	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//We get request's attributes 

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		
		try {		
			//We ask glassfish to connect the client
			app.connect(email, pass);
		} catch (Exception e1) {
			request.setAttribute("erreur", e1);
			e1.printStackTrace();
		}


		//
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/loginAns.jsp");
		dispatch.forward(request, response);
	}

}
