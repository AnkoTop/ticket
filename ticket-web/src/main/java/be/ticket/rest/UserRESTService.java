package be.ticket.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface UserRESTService {
	   @GET
	   UserListWrapper findAllUsers();
}
