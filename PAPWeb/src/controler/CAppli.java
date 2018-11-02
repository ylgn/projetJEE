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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String function = request.getParameter("function");
		System.out.println(function);
		
		String gotclassName = getServletContext().getInitParameter(function);
		System.out.println(gotclassName);
		try {
			ICTreatment controleurDedie = (ICTreatment) Class.forName(gotclassName).newInstance();
			controleurDedie.treatRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
