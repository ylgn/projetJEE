package PAP.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity

public class UserPAP implements  Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column(name="MAIL",length=50,unique=true)
	private String mail;
	@Column(name="NAME")
	private String name;
	@Column(name="CITY")
	private String city;
	@Column(name="PASS")
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
	
	public String getMail() {
		return this.mail;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setMail(java.lang.String)
	 */
	
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setMail(java.lang.String)
	 */
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getName()
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#getName()
	 */
	
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setName(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setName(java.lang.String)
	 */

	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getCity()
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#getCity()
	 */
	
	public String getCity() {
		return city;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setCity(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setCity(java.lang.String)
	 */
	
	public void setCity(String city) {
		this.city = city;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#getPass()
	 */
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#getPass()
	 */
	
	public String getPass() {
		return pass;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUser#setPass(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IUserPAP#setPass(java.lang.String)
	 */

	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
