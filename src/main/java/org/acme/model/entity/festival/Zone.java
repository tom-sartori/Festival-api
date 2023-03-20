package org.acme.model.entity.festival;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import java.util.Objects;
import java.util.Set;

import static org.acme.constant.DbCollections.FESTIVAL_COLLECTION;

@MongoEntity(collection = FESTIVAL_COLLECTION)

public class Zone {
    private String name;
    private int nbVolunteerNeeded;
    private Set<ObjectId> volunteerRefs;

    public Zone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbVolunteerNeeded() {
        return nbVolunteerNeeded;
    }

    public void setNbVolunteerNeeded(int nbVolunteerNeeded) {
        this.nbVolunteerNeeded = nbVolunteerNeeded;
    }

    public Set<ObjectId> getVolunteerRefs() {
        return volunteerRefs;
    }

    public void setVolunteerRefs(Set<ObjectId> volunteerRefs) {
        this.volunteerRefs = volunteerRefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return nbVolunteerNeeded == zone.nbVolunteerNeeded && Objects.equals(name, zone.name) && Objects.equals(volunteerRefs, zone.volunteerRefs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nbVolunteerNeeded, volunteerRefs);
    }
}
