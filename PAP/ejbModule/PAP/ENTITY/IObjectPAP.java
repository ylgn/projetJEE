package PAP.ENTITY;

public interface IObjectPAP {

	int getNumObject();
	void setNumObject(int numObject);
	String getNameObject();
	void setNameObject(String nameObject);
	String getDescriptionObject();
	void setDescriptionObject(String descriptionObject);
	double getPriceObject();
	void setPriceObject(double priceObject);
	UserPAP getSeller();
	void setSeller(UserPAP seller);
	public String toStringue();

}