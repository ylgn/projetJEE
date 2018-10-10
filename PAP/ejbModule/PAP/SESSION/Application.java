package PAP.SESSION;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import PAP.ENTITY.AlreadyExistsUserException;
import PAP.ENTITY.IUserPAPFactory;
import PAP.ENTITY.UserPAP;
import PAP.ENTITY.UserPAPFactory;

@Stateless (mappedName = "ejb/PAP")
public class Application implements IApplication {
	@PersistenceContext(unitName = "PAPdB")
	private EntityManager em;
	
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
	public EntityManager getEntityManager() {
		return em;
	}
	@Override
	public void subscribe(String name, String email, String pass, String city) throws AlreadyExistsUserException {
		em.persist(new UserPAPFactory().createUser(email, city, name, pass));
	}

}
