package PAP.ENTITY;

public class UserFactory implements IUserFactory {

	@Override
	public IUser createUser(String name, String email, String pass, String city) {
		return new User(email,name,city,pass);
	}

}
