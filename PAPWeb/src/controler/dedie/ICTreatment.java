package controler.dedie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PAP.MODEL.CLIENT.ObjectPAPForClient;
import PAP.SESSION.IApplication;

public interface ICTreatment {
	public void treatRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception ;


	
}
