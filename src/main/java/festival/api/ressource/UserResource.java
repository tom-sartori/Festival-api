package festival.api.ressource;

import festival.api.model.collection.user.User;
import festival.api.model.mapper.UserMapper;
import festival.api.repository.UserRepository;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static festival.api.constant.ApiPaths.*;


@SecurityScheme(
		scheme = "bearer",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT"
)
@Path(USER)
@ApplicationScoped
public class UserResource {

	@Inject
	UserMapper userMapper;

	private final UserRepository userRepository;

	@Inject
	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response
				.status(200)
				.entity(userMapper.toDto(userRepository.listAll()))
				.build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") ObjectId id) {
		return Response
				.status(200)
				.entity(userMapper.toDto(userRepository.findById(id)))
				.build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") ObjectId id, User user) {
		user.setId(id);
		userRepository.update(user);
		return Response
				.status(200)
				.entity(userMapper.toDto(user))
				.build();
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
	public Response deleteUser(@PathParam("id") ObjectId id) {
		userRepository.deleteById(id);
		return Response
				.status(204)
				.build();
	}
}
