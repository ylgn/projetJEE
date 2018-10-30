package PAP.SESSION;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import PAP.ENTITY.ObjectPAP;
import PAP.ENTITY.TransactionPAP;
import PAP.ENTITY.UserPAP;
import PAP.EXCEPTION.AlreadyExistsUserException;



@Stateless (mappedName = "ejb/PAP")
public class Application implements IApplication {

	@PersistenceContext(unitName = "PAPdB")
	private EntityManager em;
	
	@Override
	public boolean connect(String mail, String pass) {
		UserPAP customer = em.find(UserPAP.class, mail);
		if (customer.getPass().equals(pass)) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
	@Override
	public void subscribe(String name, String email, String pass, String city) throws AlreadyExistsUserException  {
		if (IsUserExistByMail(email)) {
			throw new AlreadyExistsUserException("An user already exists with the mail adress : "+email);
		}else { 
		em.persist(new UserPAP(email, city, name, pass));
		}
		
	}
	
	@Override
	public void dropObject(ObjectPAP o) {
		em.persist(o);
	}
	
	@Override
	public List<ObjectPAP> search(String name, String city) {
		List<ObjectPAP> searchedList = new ArrayList<ObjectPAP>();
		String query = ("SELECT o FROM ObjectPAP o WHERE o.name = :nameObject AND o.city = :cityObject");
		Query req = em.createQuery (query).setParameter("nameObject", name);
		req = em.createQuery (query).setParameter("cityObject", city);
		List<ObjectPAP> list = req.getResultList();
		for (ObjectPAP objectPAP : list) {
			searchedList.add(objectPAP);
		}
		return searchedList;
	}
	
	
	
	public String test() {
		/*String searchList="";
		String query = ("SELECT o FROM ObjectPAP");
		Query req = em.createQuery (query);
		List<ObjectPAP> listOfAllObject = req.getResultList();
		for (ObjectPAP objectPAP : listOfAllObject) {
			searchList+=objectPAP.toStringue();
		}
		return searchList;*/
		return "ok Yannis t'as réussi ton API fonctionne, bien joué mais tu ne "
				+ "sauras jamais developpeur pcq c pour les pd";
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
	
	// ############################## CHECK METHOD ##################################
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



	@Override
	public List<ObjectPAP> getlistTest() {
		// TODO Auto-generated method stub
		List<ObjectPAP> searchedList = new ArrayList<ObjectPAP>();
		String query = ("SELECT o FROM ObjectPAP o");
		Query req = em.createQuery (query);
		List<ObjectPAP> list = req.getResultList();
		for (ObjectPAP objectPAP : list) {
			searchedList.add(objectPAP);
		}
		return searchedList;
	}



	

	
	
		

}
