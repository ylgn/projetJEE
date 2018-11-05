package PAP.SESSION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import PAP.ENTITY.ObjectPAP;
import PAP.ENTITY.TransactionPAP;
import PAP.ENTITY.UserPAP;
import PAP.EXCEPTION.AlreadyExistsUserException;
import PAP.EXCEPTION.DoesntExistException;
import PAP.MODEL.CLIENT.MailPAPForClient;
import PAP.MODEL.CLIENT.ObjectPAPForClient;



@Stateless (mappedName = "ejb/PAP")
public class Application implements IApplication {

	@PersistenceContext(unitName = "PAPdB")
	private EntityManager em;
	
	@Override
	public boolean connect(String mail, String pass) throws DoesntExistException {
		UserPAP customer = getUserByMail(mail);
		if (customer.getPass().equals(pass)) {
			return true;
		}
		else {
			throw new DoesntExistException("Email ou mot de passe incorrect");
			
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
	public void dropObject(String mail,String name,String description, String city, double price) {
		
		UserPAP p = getUserByMail(mail);
		em.persist(new ObjectPAP(p,name, description, price, city));
	}
	
	@Override
	public List<ObjectPAPForClient> search(String name, String city) {
		List<ObjectPAPForClient> searchedList = new ArrayList<ObjectPAPForClient>();
		String query = ("SELECT o FROM ObjectPAP o");
		Query req = em.createQuery (query);
		req = em.createQuery (query);
		List<ObjectPAP> list = req.getResultList();
		for (ObjectPAP o : list) {
			if (o.getNameObject().equals(name) && o.getCityObject().equals(city)) {
				ObjectPAPForClient ob = new ObjectPAPForClient(o.getSeller().getMail(), o.getNameObject(), 
						o.getDescriptionObject(), o.getPriceObject(), o.getCityObject(),o.getIsSelled());
				ob.setNumObject(o.getNumObject());
				searchedList.add(ob);
				
			}
		
		}
		return searchedList;
	}
	
	
	
	public String test() {
		String res = "";
		String query = ("SELECT o FROM UserPAP o");
		Query req = em.createQuery (query);
		List<UserPAP> listOfResult = req.getResultList();
		for (UserPAP p : listOfResult) {
			res = res+"\n"+p.getMail();
		}
		return res;
	} 
		

	@Override
	public void buyObject(String mailBuyeur, int objectNumber) {
		ObjectPAP currentObject = em.find(ObjectPAP.class, objectNumber);
		UserPAP seller = currentObject.getSeller();
		UserPAP owner = getUserByMail(mailBuyeur);
		currentObject.setSelled();
		em.merge(currentObject);
		TransactionPAP tr = new TransactionPAP(owner, seller, currentObject);
		em.persist(tr);
		String objSeller = styleMailObject(seller.getName(), currentObject.getNameObject(), true);
		String objOwner = styleMailObject(owner.getName(), currentObject.getNameObject(), false);
		String contentSeller = styleMailContent(owner.getName(), seller.getName(), currentObject.getNameObject(),
				currentObject.getPriceObject(), tr.getDateTransact(), true);
		String contentOwner = styleMailContent(owner.getName(), seller.getName(), currentObject.getNameObject(),
				currentObject.getPriceObject(), tr.getDateTransact(), false);
		sendMail(seller.getMail(), objSeller, contentSeller);
		sendMail(mailBuyeur, objOwner, contentOwner);
	}

	@Override
	public Double calculateTurnover() {
		double turnoverPAP = 0;
		String query = ("SELECT o FROM TransactionPAP o");
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
		String query = ("SELECT o FROM UserPAP o");
		Query req = em.createQuery (query);
		List<UserPAP> listUser = req.getResultList();
			for (UserPAP userPAP : listUser) {
				if(userPAP.getMail().equals(mail)) {
					System.out.println(userPAP.getMail());
					return userPAP;
				}
			}return null;
	}
	
	
	public void sendMail(String mailRecipient, String object, String textMsg) {
		
		Client clientRest = ClientBuilder.newClient();
		WebTarget ressource = clientRest.target("http://51.68.226.60:8080/PAPFunctions/rest");
		ressource = ressource.path("resources/mail");
		Invocation.Builder httpQuery = ressource.request();
		Entity<MailPAPForClient> monEntity = Entity.json(new MailPAPForClient(mailRecipient, object, textMsg));
		MailPAPForClient mailCreated = httpQuery.accept(MediaType.APPLICATION_JSON).post(monEntity,MailPAPForClient.class);
	}
	
	public String styleMailObject(String name, String nameObject,Boolean seller) {
		//Utile en maintenabilité car si il y a plusieur langue à l'avenir on peut charger des bibiliothèque dedans
		if (seller) {
			return name+", votre "+nameObject+" a été vendu !";
		}else {
		return name+", confiramation d'achat de votre "+nameObject+"!";
		}
	}
	
	public String styleMailContent(String nameOwner, String nameSeller, String nameObject, double price,Date date,Boolean seller) {
		if (seller) {
			return nameOwner+" a acheté votre "+nameObject+" au prix de "+price+"le "+date.toString();
		}else {
			return " Vous avez bien acheté le"+nameObject+" de "+nameSeller+" au prix de "+price+"le "+date.toString();
		}
	}


	

	
	
		

}
