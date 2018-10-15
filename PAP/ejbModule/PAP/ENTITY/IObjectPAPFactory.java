package PAP.ENTITY;

public interface IObjectPAPFactory {

	IObjectPAP createObject(String name, String description, double price, UserPAP seller);

}