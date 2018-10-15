package PAP.ENTITY;

public interface IUserPAP {

	String getMail();
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setMail(java.lang.String)
	 */

	void setMail(String mail);
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getName()
	 */

	String getName();
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setName(java.lang.String)
	 */

	void setName(String name);
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getCity()
	 */

	String getCity();
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setCity(java.lang.String)
	 */

	void setCity(String city);

	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getPass()
	 */
	String getPass();
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setPass(java.lang.String)
	 */

	void setPass(String pass);

}