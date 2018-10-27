package PAP.SERVICES;

import java.util.ArrayList;
import PAP.ENTITY.*;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import PAP.ENTITY.ObjectPAP;

@Path("/magasin")
public class ObjectService {
	
	private static List<ObjectPAP> produits = new ArrayList<ObjectPAP>();
	
	//F2
	@POST @Path("/drop")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void  dropObj(ObjectPAP produit) {
		//ajouter des param?
		produits.add(produit);
		
	}
	
	//F3
	@GET @Path("/search/{nameProd}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public boolean searchObj(@PathParam("nameProd")ObjectPAP name) {
		
		for(ObjectPAP nameProd : produits) {
			if(produits.contains(name)){
				return produits.contains(name);
            } else
            	System.out.println("L'objet recherché n'existe pas");
	}
	
	//F5
	@GET @Path("/ca")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public int calcCA(int ca) {
		//cest avec la bdd et je sais pas comment faire
		//TransactionPAP t = 0;
		//t.getPAPFeesAmount();
		return ca;
		
		
	}
	
}
