package PAP.ENTITY;

import javax.ejb.Remote;

@Remote
public interface IUserFactory {
	public void createUser(String name,String email,String pass,String city);
}
