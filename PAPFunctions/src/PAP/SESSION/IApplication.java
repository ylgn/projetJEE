package PAP.SESSION;

import java.util.List;

import javax.ejb.Remote;

import PAP.MODEL.UserPAP;
import PAP.MODEL.CLIENT.ObjectPAPForClient;

@Remote
public interface IApplication {
	public boolean connect(String mail, String pass) throws Exception;
	public void subscribe(String name,String email,String pass,String city) throws Exception;
	public List<ObjectPAPForClient> search(String name, String city);
	public void dropObject(String mail,String name,String description, String city, double price);
	public void buyObject(String mailBuyeur, int objectNumber);
	public Double calculateTurnover();
	//A supprimer pour la prod
	public String test();
	
}
