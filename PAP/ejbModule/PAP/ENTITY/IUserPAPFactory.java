package PAP.ENTITY;

public interface IUserPAPFactory {

	UserPAP createUser(String mail, String city, String name, String pass);

}