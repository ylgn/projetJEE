package PAP.ENTITY;

import javax.ejb.Remote;

@Remote
public interface IUser {
	public String getName();
	public String getCity();
	public String getPass();
	public String getMail();	
}
