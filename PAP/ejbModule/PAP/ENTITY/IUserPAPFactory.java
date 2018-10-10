package PAP.ENTITY;

import javax.persistence.EntityManager;

public interface IUserPAPFactory {

	UserPAP createUser(String mail, String city, String name, String pass);

}