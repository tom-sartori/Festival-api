package org.acme.ressource;

import org.acme.mapper.FestivalMapper;
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

    @Inject
    FestivalMapper festivalMapper;

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
                .entity(festivalMapper.toDto(festival))
                .build();
    }

    @GET
    @Produces("application/json")
    @PermitAll
    public Response read() {
        return Response
                .status(200)
                .entity(festivalMapper.toDto(festivalRepository.listAll()))
                .build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    @PermitAll
    public Response read(@PathParam("id") String id) {
        return Response
                .status(200)
                .entity(festivalMapper.toDto(festivalRepository.findById(new ObjectId(id))))
                .build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Festival festival) {
        festival.setId(new ObjectId(id));
        festivalRepository.update(festival);
        return Response
                .status(200)
                .entity(festivalMapper.toDto(festival))
                .build();
    }

    @DELETE
    @Consumes("*/*")
    @Produces("*/*")
    @Path("/{id}")
    public Response delete(@PathParam("id") ObjectId id) {
        festivalRepository.deleteById(id);
        return Response
                .status(204)
                .build();
    }
}
