package PAP.SESSION;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import PAP.ENTITY.IUser;
import PAP.ENTITY.IUserFactory;
import PAP.ENTITY.UserFactory;

@Stateless (mappedName = "ejb/PAP")
public class Application implements IApplication {
	@PersistenceContext(unitName = "PAPdB")
	EntityManager em;
	
	@Override
	public void connect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropObject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buyObject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void calculateTurnover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void subscribe(String name, String email, String pass, String city) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		IUserFactory fact = new UserFactory();
		IUser newUser = fact.createUser(name, email, pass, city);
		em.persist(newUser);
		
	
	}
}
