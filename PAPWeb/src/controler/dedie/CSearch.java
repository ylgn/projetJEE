package controler.dedie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import PAP.SESSION.IApplication;

public class CSearch implements ICTreatment {
	IApplication app;

	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		String city = request.getParameter("city");
		String name = request.getParameter("name");
		
			try {
				app.search(name, city);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("erreur",e);
				System.err.println(e);
			}
		


		//
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/search.jsp");
		dispatch.forward(request, response);
	}
	}

	

