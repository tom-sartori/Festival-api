package festival.api.ressource;

import festival.api.constant.ApiPaths;
import festival.api.model.collection.festival.Festival;
import festival.api.model.dto.festival.FestivalDto;
import festival.api.model.mapper.FestivalMapper;
import festival.api.repository.FestivalRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(ApiPaths.FESTIVAL)
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
    public Response create(FestivalDto festivalDto) {
        Festival festival = festivalMapper.toEntity(festivalDto);
        festival.setId(null);
        festivalRepository.persist(festival);
        return Response
                .status(201)
                .entity(festivalMapper.toDto(festival))
                .build();
    }

    @GET
    @Consumes("*/*")
    @Produces("application/json")
    public Response read() {
        List<FestivalDto> festivalDtos = festivalMapper.toDto(festivalRepository.listAll());
        return Response
                .status(Response.Status.OK)
                .entity(festivalDtos)
//                .entity(festivalRepository.listAll())
                .build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
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
    public Response update(@PathParam("id") ObjectId id, FestivalDto festivalDto) {
        festivalDto.setId(id.toString());
        festivalRepository.update(festivalMapper.toEntity(festivalDto));
        return Response
                .status(Response.Status.NO_CONTENT)
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
