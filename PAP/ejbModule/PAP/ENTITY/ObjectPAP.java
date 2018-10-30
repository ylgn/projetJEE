package PAP.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class ObjectPAP implements Serializable{
	
	@Id
	@GeneratedValue
	private int numObject;
	@Column(name="NAME")
	private String nameObject;
	@Column(name="DESCRIPTION")
	private String descriptionObject;
	@Column(name="PRICE")
	private Double priceObject;
	@JoinColumn(name="OWNER")
	private UserPAP seller;
	@Column(name="CITY")
	private String cityObject;
	@Column(name="SOLD")
	private Boolean isSelled = false;
	private static final long serialVersionUID = 1L;
	
	public ObjectPAP() {
		
	}
	
	public ObjectPAP(UserPAP seller, String name, String description, double price, String city) {
		this.nameObject =name;
		this.descriptionObject = description;
		this.priceObject = price;
		this.seller = seller;
		this.cityObject = city;
		
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getNumObject()
	 */

	public int getNumObject() {
		return numObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setNumObject(int)
	 */
	
	public void setNumObject(int numObject) {
		this.numObject = numObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getNameObject()
	 */
	
	public String getNameObject() {
		return nameObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setNameObject(java.lang.String)
	 */
	
	public void setNameObject(String nameObject) {
		this.nameObject = nameObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getDescriptionObject()
	 */
	
	public String getDescriptionObject() {
		return descriptionObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setDescriptionObject(java.lang.String)
	 */
	
	public void setDescriptionObject(String descriptionObject) {
		this.descriptionObject = descriptionObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getPriceObject()
	 */
	
	public double getPriceObject() {
		return priceObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setPriceObject(double)
	 */
	
	public void setPriceObject(double priceObject) {
		this.priceObject = priceObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getSeller()
	 */

	public UserPAP getSeller() {
		return seller;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setSeller(PAP.ENTITY.UserPAP)
	 */
	
	public void setSeller(UserPAP seller) {
		this.seller = seller;
	}
	
	public void setSelled() {
		this.isSelled = true;
	}

	public String getCityObject() {
		return cityObject;
	}

	public void setCityObject(String cityObject) {
		this.cityObject = cityObject;
	}

	public Boolean getIsSelled() {
		return isSelled;
	}

	public void setIsSelled(Boolean isSelled) {
		this.isSelled = isSelled;
	}

	public void setPriceObject(Double priceObject) {
		this.priceObject = priceObject;
	}

	

}
