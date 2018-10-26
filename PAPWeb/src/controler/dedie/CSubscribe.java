package controler.dedie;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.enterprise.security.jauth.callback.PrivateKeyCallback.Request;

import PAP.SESSION.IApplication;

public class CSubscribe implements ICTreatment {
	Context ctx;
	IApplication app;
	String name,email,pass,city;
	
	public CSubscribe() throws NamingException {
		
		
		//Ca a l'air de fonctionner mais nullPointerException
		//DataSource ds = (DataSource) envCtx.lookup("ejb/PAP")
		
	}
	
	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//We get request's attributes 
		
		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
			System.out.println(app);
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.name = (String) request.getParameter("name");
		this.email = (String) request.getParameter("email");
		this.pass = (String) request.getParameter("pass");
		this.city = (String) request.getParameter("city");	
		
		//We ask glassfish for suscribe the adherent
		app.subscribe(name, email, pass, city);
		//
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/subscribeAns.jsp");
		dispatch.forward(request, response);
	}

}
