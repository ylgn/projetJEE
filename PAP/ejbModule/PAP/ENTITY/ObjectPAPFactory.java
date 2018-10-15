package PAP.ENTITY;

public class ObjectPAPFactory implements IObjectPAPFactory {
	/* (non-Javadoc)
	 * @see PAP.ENTITY.IObjectPAPFactory#createObject(java.lang.String, java.lang.String, double, PAP.ENTITY.UserPAP)
	 */
	@Override
	public IObjectPAP createObject(String name, String description, double price, UserPAP seller) {
		return new ObjectPAP(name,description,price,seller);
	}
}
