package PAP.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserPAP implements  Serializable, IUserPAP{
	
	@Id @GeneratedValue
	private int id;
	private String mail;
	private String name;
	private String city;
	private String pass;
	
	public UserPAP() {
		
	}
	public UserPAP(String mail,String city,String name,String pass) {
		this.mail =mail;
		this.city = city;
		this.name = name;
		this.pass = pass;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getMail()
	 */
	 
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#getMail()
	 */
	@Override
	public String getMail() {
		return mail;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setMail(java.lang.String)
	 */
	
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setMail(java.lang.String)
	 */
	@Override
	public void setMail(String mail) {
		this.mail = mail;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getName()
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setName(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getCity()
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#getCity()
	 */
	@Override
	public String getCity() {
		return city;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setCity(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setCity(java.lang.String)
	 */
	@Override
	public void setCity(String city) {
		this.city = city;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getPass()
	 */
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#getPass()
	 */
	@Override
	public String getPass() {
		return pass;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setPass(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setPass(java.lang.String)
	 */
	@Override
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
