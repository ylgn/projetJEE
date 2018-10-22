package PAP.SESSION;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.sun.xml.ws.runtime.dev.Session;

import PAP.ENTITY.AlreadyExistsUserException;
import PAP.ENTITY.ObjectPAP;
import PAP.ENTITY.ObjectPAPFactory;
import PAP.ENTITY.TransactionPAP;
import PAP.ENTITY.UserPAP;
import PAP.ENTITY.UserPAPFactory;

@Stateless (mappedName = "ejb/PAP")
public class Application implements IApplication {

	@PersistenceContext(unitName = "PAPdB")
	private EntityManager em;
	
	@Override
	public void connect(String mail, String pass) {
		
		String searchlist="";
		String query = "SELECT o FROM UserPAP WHERE o.pass= :passUser AND o.mail= :mail";
		Query req = em.createQuery(query);
		req.setParameter("passUser",pass);

	}

	@Override
	public void dropObject(String name,String description,double price) {
		//UserPAP seller = new UserPAP();
		//em.persist(new ObjectPAPFactory().createObject(name, description, price, seller));

	}

	@Override
	public String search(String name, String city) {
		String searchList="";
		String query = ("SELECT o FROM ObjectPAP o WHERE o.nameObject = :nameObject and o.cityObject = :cityObject");
		Query req = em.createQuery (query).setParameter("nameObject", name);
		req.setParameter("cityObject", city);
		List<ObjectPAP> listOfAllObject = req.getResultList();
		for (ObjectPAP objectPAP : listOfAllObject) {
			searchList+=objectPAP.toStringue();
		}
		return searchList;
	} 
		

	@Override
	public void buyObject(String product) {
		// Lire un string et instancier une nouvelle transaction

	}

	@Override
	public Double calculateTurnover() {
		double turnoverPAP = 0;
		String query = ("SELECT * FROM TransactionPAP");
		Query req = em.createQuery(query);
		List<TransactionPAP> listTransact = req.getResultList();
		for (TransactionPAP transactionPAP : listTransact) {
			turnoverPAP+=transactionPAP.getPAPFeesAmount();
		}
		return turnoverPAP;

	}
	
	@Override
	public void subscribe(String name, String email, String pass, String city)  {
		if (IsUserExistByMail(email)) {
			//throw new AlreadyExistsUserException("An user already exists with the mail adress : "+email);
		}else { 
		em.persist(new UserPAPFactory().createUser(email, city, name, pass));
		}
		
	}
	public Boolean IsUserExistByMail(String mail) {
		String query = ("SELECT o FROM UserPAP o WHERE o.mail = :adresseEMail");
		Query req = em.createQuery (query).setParameter("adresseEMail", mail);
		return !req.getResultList().isEmpty();
	}
	public UserPAP getUserByMail(String mail) {
		String query = ("SELECT o FROM UserPAP o WHERE o.mail = :adresseEMail");
		Query req = em.createQuery (query).setParameter("adresseEMail", mail);
		List<UserPAP> listUser = req.getResultList();
		for (UserPAP userPAP : listUser) {
			if(userPAP.getMail()==mail) {
				return userPAP;
			}
		}return null;
	}
	
		

}
