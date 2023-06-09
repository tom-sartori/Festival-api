package festival.api.model.collection.festival;

import festival.api.model.dto.festival.ZoneDto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;


public class Zone {
    private String name;
    private int nbVolunteerNeeded;
    private List<ObjectId> volunteerRefs;

    public Zone() {
    }

    public Zone(ZoneDto zoneDto, List<ObjectId> volunteerRefList) {
        this.name = zoneDto.getName();
        this.nbVolunteerNeeded = zoneDto.getNbVolunteerNeeded();
        this.volunteerRefs = volunteerRefList;
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

    public List<ObjectId> getVolunteerRefs() {
        return volunteerRefs;
    }

    public void setVolunteerRefs(List<ObjectId> volunteerRefs) {
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
