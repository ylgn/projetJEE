package PAP.SESSION;

import java.util.List;

import PAP.MODEL.ObjectPAPForClient;
import PAP.MODEL.UserPAPForClient;


public interface IApplication {
	public boolean connect(String mail, String pass) throws Exception;
	public void subscribe(String name,String email,String pass,String city) throws Exception;
	public List<ObjectPAPForClient> search(String name, String city);
	public void dropObject(String mail,String name,String description, String city, double price);
	public void buyObject(String objectStringued);
	public Double calculateTurnover();
	//A supprimer pour la prod
	public String test();
	public List<ObjectPAPForClient> getlistTest();
	public UserPAPForClient getUserByMail(String mail);
}
