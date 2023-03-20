package org.acme.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.acme.model.entity.festival.Festival;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FestivalRepository implements PanacheMongoRepository<Festival> {

}
