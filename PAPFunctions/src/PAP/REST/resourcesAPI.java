package PAP.REST;

import java.util.ArrayList;
import java.util.List;

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

import PAP.ENTITY.ObjectPAP;
import PAP.MODEL.ObjectPAPForClient;
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
 		List<ObjectPAP> l = app.search(name, city);
 		List<ObjectPAPForClient> returnedList = new ArrayList<>();
 		for (ObjectPAP o : l) {
			returnedList.add(new ObjectPAPForClient(o.getSeller().getMail(), o.getNameObject(), o.getDescriptionObject(), o.getPriceObject(), o.getCityObject()));
		}
 		return returnedList;
 		
 	}
 	
 	/*
 	@GET
	@Path("objects")
	@Produces({MediaType.APPLICATION_JSON})
 	public List<ObjectPAP> getObjects(){
 		try {
			ctx = new InitialContext();
			app = (IApplication) ctx.lookup("ejb/PAP");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		return app.getlistTest();
 	
 	}
 	
 */
 
}
