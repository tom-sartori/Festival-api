package org.acme.ressource;

import org.acme.model.entity.festival.Festival;
import org.acme.repository.FestivalRepository;
import org.bson.types.ObjectId;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static org.acme.constant.ApiPaths.FESTIVAL;

@Path(FESTIVAL)
@ApplicationScoped
public class FestivalResource {

    private final FestivalRepository festivalRepository;

    @Inject
    public FestivalResource(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Festival festival) {
        festivalRepository.persist(festival);
        return Response
                .status(201)
                .entity(festival)
                .build();
    }

    @GET
    @Produces("application/json")
    @PermitAll
    public Response read() {
        return Response
                .status(200)
                .entity(festivalRepository.findAll())
                .build();
    }

    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    @PermitAll
    public Response read(@PathParam("id") String id) {
        return Response
                .status(200)
                .entity(festivalRepository.findById(new ObjectId(id)))
                .build();
    }

    @PATCH
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Festival festival) {
        festival.setId(new ObjectId(id));
        festivalRepository.update(festival);
        return Response
                .status(200)
                .entity(festival)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        festivalRepository.deleteById(new ObjectId(id));
        return Response
                .status(204)
                .build();
    }
}
