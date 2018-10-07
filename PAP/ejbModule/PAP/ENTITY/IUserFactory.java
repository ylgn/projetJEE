package PAP.ENTITY;

import javax.ejb.Remote;

@Remote
public interface IUserFactory {
	public IUser createUser(String name,String email,String pass,String city);
}
