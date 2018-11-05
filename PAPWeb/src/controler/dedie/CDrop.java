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

import PAP.MODEL.CLIENT.ObjectPAPForClient;
import PAP.SESSION.IApplication;

public class CDrop implements ICTreatment {
	Context ctx;
	IApplication app;
	Boolean allowed;
	String name,description;
	double price;
	HttpSession session;
	String city;
	public CDrop() throws NamingException {
		ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
		
	}
	
	

	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		this.name = request.getParameter("name");
		this.description = request.getParameter("description");
		this.city = request.getParameter("city");
		this.price = Double.parseDouble(request.getParameter("price"));
		HttpSession session = request.getSession();
		//System.out.println(session.getAttribute("connected"));
		
		if (session.getAttribute("connected").equals("ok")) {
			String mail = (String) session.getAttribute("mail");
			Client clientRest = ClientBuilder.newClient();
			WebTarget ressource = clientRest.target("http://51.68.226.60:8080/PAPFunctions/rest");
			ressource = ressource.path("resources/objects");
			Invocation.Builder httpQuery = ressource.request();
			
			Entity<ObjectPAPForClient> monEntity = Entity.json(new ObjectPAPForClient(mail, name, description, price, city));
			ObjectPAPForClient prodCree = httpQuery.accept(MediaType.APPLICATION_JSON).post(monEntity,ObjectPAPForClient.class);
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/sellAns.jsp");
		dispatch.forward(request, response);
	}

}
