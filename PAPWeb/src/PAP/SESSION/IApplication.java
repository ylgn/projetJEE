package PAP.SESSION;

import java.util.List;

import javax.ejb.Remote;

import PAP.MODEL.ObjectPAP;
import PAP.MODEL.UserPAP;


public interface IApplication {
	public boolean connect(String mail, String pass) throws Exception;
	public void subscribe(String name,String email,String pass,String city) throws Exception;
	public List<ObjectPAP> search(String name, String city);
	public void dropObject(String mail,String name,String description, String city, double price);
	public void buyObject(String objectStringued);
	public Double calculateTurnover();
	//A supprimer pour la prod
	public String test();
	public List<ObjectPAP> getlistTest();
	public UserPAP getUserByMail(String mail);
}
