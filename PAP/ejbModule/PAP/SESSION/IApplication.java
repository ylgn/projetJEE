package PAP.SESSION;

import java.util.List;

import javax.ejb.Remote;

import PAP.ENTITY.ObjectPAP;

@Remote
public interface IApplication {
	public boolean connect(String mail, String pass);
	public void subscribe(String name,String email,String pass,String city) throws Exception;
	public List<ObjectPAP> search(String name, String city);
	public void dropObject(ObjectPAP o);
	public void buyObject(String objectStringued);
	public Double calculateTurnover();
	//A supprimer pour la prod
	public String test();
	public List<ObjectPAP> getlistTest();
}
