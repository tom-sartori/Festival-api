package org.acme.ressource;

import org.acme.model.entity.User;
import org.acme.repository.UserRepository;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.acme.constant.ApiPaths.*;


@SecurityScheme(
		scheme = "bearer",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT"
)
@Path(USER)
@ApplicationScoped
public class UserResource {

	private final UserRepository userRepository;

	@Inject
	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userRepository.listAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") String id) {
		return userRepository.findById(new ObjectId(id));
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUser(@PathParam("id") String id, User user) {
		user.setId(new ObjectId(id));
		userRepository.update(user);
	}

	@POST
	@Path(REGISTER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(User user) {
		return userRepository.register(user);
	}

	@POST
	@Path(LOGIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(User user) {
		return userRepository.login(user);
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") String id) {
		User user = userRepository.findById(new ObjectId(id));
		userRepository.delete(user);
	}
}
