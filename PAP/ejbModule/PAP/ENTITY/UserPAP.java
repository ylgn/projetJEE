package PAP.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserPAP implements  Serializable{
	
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
	 
	public String getMail() {
		return mail;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setMail(java.lang.String)
	 */
	
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getName()
	 */
	
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setName(java.lang.String)
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getCity()
	 */
	
	public String getCity() {
		return city;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setCity(java.lang.String)
	 */
	
	public void setCity(String city) {
		this.city = city;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getPass()
	 */
	public String getPass() {
		return pass;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setPass(java.lang.String)
	 */
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
