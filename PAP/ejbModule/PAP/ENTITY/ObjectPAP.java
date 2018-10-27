package PAP.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class ObjectPAP implements Serializable, IObjectPAP {
	
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
	
	public ObjectPAP(String name, String description, double price, UserPAP seller) {
		this.nameObject =name;
		this.descriptionObject = description;
		this.priceObject = price;
		this.seller = seller;
		this.cityObject = seller.getCity();
		
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getNumObject()
	 */
	@Override
	public int getNumObject() {
		return numObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setNumObject(int)
	 */
	@Override
	public void setNumObject(int numObject) {
		this.numObject = numObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getNameObject()
	 */
	@Override
	public String getNameObject() {
		return nameObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setNameObject(java.lang.String)
	 */
	@Override
	public void setNameObject(String nameObject) {
		this.nameObject = nameObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getDescriptionObject()
	 */
	@Override
	public String getDescriptionObject() {
		return descriptionObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setDescriptionObject(java.lang.String)
	 */
	@Override
	public void setDescriptionObject(String descriptionObject) {
		this.descriptionObject = descriptionObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getPriceObject()
	 */
	@Override
	public double getPriceObject() {
		return priceObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setPriceObject(double)
	 */
	@Override
	public void setPriceObject(double priceObject) {
		this.priceObject = priceObject;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#getSeller()
	 */
	@Override
	public UserPAP getSeller() {
		return seller;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setSeller(PAP.ENTITY.UserPAP)
	 */
	@Override
	public void setSeller(UserPAP seller) {
		this.seller = seller;
	}
	public String toStringue() {
		String objectStringed ="";
		objectStringed+= this.numObject+"/next/";
		objectStringed+= this.nameObject+"/next/";
		objectStringed+= this.priceObject+"/next/";
		objectStringed+= this.cityObject+"/nextLine/";
		return objectStringed;
	}
	public void setSelled() {
		this.isSelled = true;
	}

	

}
