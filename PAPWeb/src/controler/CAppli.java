package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controler.dedie.ICTreatment;

/**
 * Servlet implementation class CAppli
 */
@WebServlet("/CAppli")
public class CAppli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CAppli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String function = request.getParameter("function");
		String className = getServletContext().getInitParameter(function);
		try {
			ICTreatment controleurDedie = (ICTreatment) Class.forName(className).newInstance();
			controleurDedie.treatRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
