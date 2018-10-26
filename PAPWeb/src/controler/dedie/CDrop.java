package controler.dedie;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PAP.SESSION.IApplication;

public class CDrop implements ICTreatment {
	IApplication app;
	Boolean allowed;
	String name,description;
	double price;
	HttpSession session;
	public CDrop() throws NamingException {
		
	}
	
	

	@Override
	public void treatRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		
	}

}
