package org.acme.model.dto.festival;
import org.bson.types.ObjectId;

import java.util.Objects;
import java.util.Set;

public class ZoneDto {
    private String name;
    private int nbVolunteerNeeded;
    private Set<ObjectId> volunteerRefs;

    public ZoneDto() {
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
        ZoneDto zoneDto = (ZoneDto) o;
        return nbVolunteerNeeded == zoneDto.nbVolunteerNeeded && Objects.equals(name, zoneDto.name) && Objects.equals(volunteerRefs, zoneDto.volunteerRefs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nbVolunteerNeeded, volunteerRefs);
    }
}
