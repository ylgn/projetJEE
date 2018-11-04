package PAP.REST;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import PAP.MODEL.CLIENT.MailPAPForClient;
import PAP.MODEL.CLIENT.ObjectPAPForClient;
import PAP.SESSION.IApplication;

@Path("resources")
public class resourcesAPI {
 private IApplication app;
 private Context ctx;
 
 	// A SUPPRIMER POUR LA PROD
 	@GET
	@Path("test")
	@Produces({MediaType.TEXT_PLAIN})
	public String test(){
		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
			//System.out.println("app " + object);
			return app.test();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return "noooooon";
		
	}
 	
 	@POST
	@Path("objects")
	@Consumes(MediaType.APPLICATION_JSON)
 	public void addObject(ObjectPAPForClient o) {
 	
 		
 		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
			app.dropObject(o.getSeller(), o.getNameObject(), o.getDescriptionObject(), o.getCityObject(), o.getPriceObject());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}
 	
 	
 	@GET
	@Path("objects/{nameObject}/{cityObject}")
	@Produces({MediaType.APPLICATION_JSON})
 	public List<ObjectPAPForClient> getObjectsByNameAndCity(@PathParam("nameObject") String name,@PathParam("cityObject") String city){
 	
 		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
 		
 		return app.search(name, city);
 		
 	}
 	
 	@GET
	@Path("turnover/{key}")
	@Produces({MediaType.APPLICATION_JSON})
 	public Double getTurnover(@PathParam("key") String key){
 	//Pas secure, car un bot pour essayer de se connecter en essayant toutes les combinaison possbiles
 		//A imaginer par l'avenir
 		
 		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
 		if (key.equals("2018")) {
 			return app.calculateTurnover();
		}
		return null;
 		
 		
 	}
 	
 	
 	@POST
	@Path("mail")
	@Consumes(MediaType.APPLICATION_JSON)
 	public void sendMail(MailPAPForClient m){
 		 // Recipient's email ID needs to be mentioned.
 		

 	       String to =  m.getRecipiant();

 	      // Sender's email ID needs to be mentioned
 	      String from = "pap.projet@outlook.com";
 	      String password = "paris16iut143";

 	      // Assuming you are sending email through relay.jangosmtp.net
 	      String host =  "smtp.office365.com";

 	  

 	     Properties prop = new Properties();
 	    prop.put("mail.smtp.auth", true);
 	    prop.put("mail.smtp.starttls.enable", "true");
 	    prop.put("mail.smtp.host", host);
 	    prop.put("mail.smtp.port", "587");
 	    prop.put("mail.smtp.ssl.trust", host);
 	    
 	   Session session = Session.getInstance(prop, new Authenticator() {
 		    @Override
 		    protected PasswordAuthentication getPasswordAuthentication() {
 		        return new PasswordAuthentication(from, password);
 		    }
 		});
 	   
 	  Message message = new MimeMessage(session);
 	 try {
		message.setFrom(new InternetAddress(from));
		message.setRecipients(
		Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(m.getOb());
			 	  
		String msg = m.getContent();
			 	  
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html");
			 	  
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
			 	  
		message.setContent(multipart);
			 	  
		Transport.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	 
 	}
 	
 
 
}
