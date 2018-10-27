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
	Context ctx;
	IApplication app;
	String name,email,pass,city;
	
	public CSubscribe() throws NamingException {
		ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
		
		//Ca a l'air de fonctionner mais nullPointerException
		//DataSource ds = (DataSource) envCtx.lookup("ejb/PAP")
		
	}
	
	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//We get request's attributes 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String city = request.getParameter("city");
		
		try {		
			//We ask glassfish to suscribe the adherent
			app.subscribe(name, email, pass, city);
		} catch (Exception e1) {
			request.setAttribute("erreur", e1);
			e1.printStackTrace();
		}
		
//		this.name = (String) request.getParameter("name");
//		this.email = (String) request.getParameter("email");
//		this.pass = (String) request.getParameter("pass");
//		this.city = (String) request.getParameter("city");	


		//
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/subscribeAns.jsp");
		dispatch.forward(request, response);
	}

}
