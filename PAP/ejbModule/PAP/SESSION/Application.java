package PAP.SESSION;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import PAP.ENTITY.IUserPAP;
import PAP.ENTITY.IUserPAPFactory;
import PAP.ENTITY.UserPAP;
import PAP.ENTITY.UserPAPFactory;

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
	public void subscribe(String name, String email, String pass, String city) {
		IUserPAPFactory fact = new UserPAPFactory();
		UserPAP newUser = fact.createUser(email, city, name, pass);
		em.persist(new UserPAPFactory().createUser(email, city, name, pass));
	}
}
