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

import PAP.EXCEPTION.NoConnectedException;
import PAP.SESSION.IApplication;

public class CBuy implements ICTreatment {
	Context ctx;
	IApplication app;
	String name,city;
	
	public CBuy() throws NamingException {
		ctx = new InitialContext();
		app = (IApplication) ctx.lookup("ejb/PAP");
	}
	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		String numbergotObject = (String) request.getParameter("objectNumber");
		String numbergotObjectChar = Character.toString(numbergotObject.charAt(0));
		int objectNumber = Integer.parseInt(numbergotObjectChar);
		
		HttpSession session = request.getSession();
		if (session.getAttribute("connected").equals("ok")) {
			String mailBuyeur = (String) session.getAttribute("mail");
			System.out.println(mailBuyeur);
			System.out.println(objectNumber);
			app.buyObject(mailBuyeur, objectNumber);
		
		
		//
	}
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/buyAns.jsp");
		dispatch.forward(request, response);

	}
}
