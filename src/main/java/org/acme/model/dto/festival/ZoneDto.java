package org.acme.model.dto.festival;

import org.acme.model.entity.festival.Zone;

import java.util.List;
import java.util.Objects;


public class ZoneDto {
    private String name;
    private int nbVolunteerNeeded;
    private List<VolunteerDto> volunteers;

    public ZoneDto() {
    }

    public ZoneDto(Zone zone, List<VolunteerDto> volunteers) {
        this.name = zone.getName();
        this.nbVolunteerNeeded = zone.getNbVolunteerNeeded();
        this.volunteers = volunteers;
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

    public List<VolunteerDto> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<VolunteerDto> volunteers) {
        this.volunteers = volunteers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoneDto zoneDto = (ZoneDto) o;
        return nbVolunteerNeeded == zoneDto.nbVolunteerNeeded && Objects.equals(name, zoneDto.name) && Objects.equals(volunteers, zoneDto.volunteers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nbVolunteerNeeded, volunteers);
    }
}
