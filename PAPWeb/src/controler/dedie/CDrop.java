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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import PAP.MODEL.ObjectPAP;
import PAP.SESSION.IApplication;

public class CDrop implements ICTreatment {
	Context ctx;
	IApplication app;
	Boolean allowed;
	String name,description;
	double price;
	HttpSession session;
	public CDrop() throws NamingException {
		ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
		
	}
	
	

	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		this.name = request.getParameter("name");
		this.description = request.getParameter("description");
		this.price = Double.parseDouble(request.getParameter("price"));
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("connected"));
		
		if (session.getAttribute("connected").equals("ok")) {
			String mail = (String) session.getAttribute("mail");
			Client clientRest = ClientBuilder.newClient();
			WebTarget ressource = clientRest.target("http://51.68.226.60:8080/PAPFunctions/rest");
			ressource = ressource.path("resources/objects");
			Invocation.Builder httpQuery = ressource.request();
			
			Entity<ObjectPAP> monEntity = Entity.json(new ObjectPAP(mail, name, description, price, "Poissy"));
			ObjectPAP prodCree = httpQuery.accept(MediaType.APPLICATION_JSON).post(monEntity,ObjectPAP.class);
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/sellAns.jsp");
		dispatch.forward(request, response);
	}

}
