package PAP.ENTITY;

public class UserPAPFactory implements IUserPAPFactory {
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAPFactory#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public IUserPAP createUser(String mail, String city,String name,String pass)   {
		return new UserPAP(mail, city, name, pass);
	}
}
