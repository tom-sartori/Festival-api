package festival.api.repository;


import festival.api.model.collection.festival.Festival;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FestivalRepository implements PanacheMongoRepository<Festival> {

}
