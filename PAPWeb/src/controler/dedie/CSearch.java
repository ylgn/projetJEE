package controler.dedie;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PAP.MODEL.CLIENT.ObjectPAPForClient;
import PAP.SESSION.IApplication;

public class CSearch implements ICTreatment {
	IApplication app;

	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
			try {
				
					List<ObjectPAPForClient> listeResultat = app.search(name,city);
					request.setAttribute("liste", listeResultat);
			        request.setAttribute( "name", name );
			        request.setAttribute( "city", city);
			        request.setAttribute( "city", city);
			        request.setAttribute( "city", city);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("erreur",e);
				System.err.println(e);
			}
		


		//
		RequestDispatcher dispatch = request.getRequestDispatcher("./View/searchAns.jsp");
		dispatch.forward(request, response);
	
	}
	}

	

