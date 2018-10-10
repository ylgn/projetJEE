package PAP.ENTITY;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.apple.eawt.Application;

public class UserPAPFactory implements IUserPAPFactory {
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAPFactory#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UserPAP createUser(String mail, String city,String name,String pass)   {
		//Query req = em.createQuery ("SELECT a FROM USERPAP a WHERE a.MAIL = :param2");
		
		//if (req.setParameter ("param2",mail) == null) {
			//throw new AlreadyExistsUserException("User "+name+" as already an account with "+mail);
		//}
		return new UserPAP(mail, city, name, pass);
	}
}
