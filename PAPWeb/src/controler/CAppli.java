package controler;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PAP.SESSION.IApplication;
import controler.dedie.ICTreatment;

/**
 * Servlet implementation class CAppli
 */
@WebServlet("/CAppli")
public class CAppli extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Context ctx;
	 IApplication app;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CAppli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String function = request.getParameter("function");
		String className = getServletContext().getInitParameter(function);
		try {
			ICTreatment controleurDedie = (ICTreatment) Class.forName(className).newInstance();
			controleurDedie.treatRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
