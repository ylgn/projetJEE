package PAP.SESSION;

import javax.ejb.Remote;

import PAP.ENTITY.AlreadyExistsUserException;
import PAP.ENTITY.UserPAP;

@Remote
public interface IApplication {
	public void connect(String mail, String pass);
	public void subscribe(String name,String email,String pass,String city) ;
	public void dropObject(String name,String description,double price);
	public String search(String name, String city);
	public void buyObject(String objectStringued);
	public Double calculateTurnover();
	
	
	
}
