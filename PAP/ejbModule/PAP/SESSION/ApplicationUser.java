package PAP.SESSION;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import PAP.ENTITY.IUserPAP;
import PAP.ENTITY.UserPAP;

@Stateful (mappedName = "ejb/PAP")
public class ApplicationUser {
	@PersistenceContext(unitName = "PAPdB")
	private IUserPAP currentUser;
	private EntityManager em;

	
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
