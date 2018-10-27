package PAP.SERVICES;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("object")
public class ObjectService {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String test() {
		return "<h1> ça marche enfin cette merde #MerceMourad</h1>";
	}
}
