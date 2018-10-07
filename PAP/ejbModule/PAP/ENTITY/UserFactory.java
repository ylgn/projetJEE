package PAP.ENTITY;

public class UserFactory implements IUserFactory {

	@Override
	public void createUser(String name, String email, String pass, String city) {
		new User(email,name,city,pass);
	}

}
