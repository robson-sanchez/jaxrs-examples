package br.com.rvvsanchez.api.rest.jaxrs.server.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rvvsanchez.api.rest.jaxrs.server.model.User;
import br.com.rvvsanchez.api.rest.jaxrs.server.repository.UserRepository;

@Component
@Path("/users")
public class UserEndpoint {

  @Context 
  private HttpServletRequest request;
  
  @Autowired
  private UserRepository repository;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> getUsers() {
    return repository.getUsers();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUserById(@PathParam("id") Long id) {
    return repository.getUserById(id);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createUser(User user) throws URISyntaxException {
    User result = repository.addUser(user);

    String location = request.getRequestURI() + "/" + result.getId();

    return Response.created(new URI(location)).entity(result).build();
  }
  
}
