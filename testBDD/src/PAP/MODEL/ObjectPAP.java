package PAP.MODEL;

public class ObjectPAP {
	

	private int numObject;
	private String nameObject;
	private String descriptionObject;
	private Double priceObject;
	private String ownerMail;
	private String cityObject;
	private Boolean isSelled = false;
	
	
	public ObjectPAP() {
		
	}
	
	public ObjectPAP(String mail,String name, String description, double price, String city) {
		this.nameObject =name;
		this.descriptionObject = description;
		this.priceObject = price;
		this.cityObject = city;
		this.ownerMail= mail;
		
		
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

	public String getSeller() {
		return ownerMail;
	}
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAP#setSeller(PAP.ENTITY.UserPAP)
	 */
	
	public void setSeller(String ownerMail) {
		this.ownerMail = ownerMail;
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
