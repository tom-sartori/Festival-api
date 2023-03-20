package org.acme.model.entity.festival;

import java.util.List;
import java.util.Objects;

public class Slot {

    private String startHour;
    private String endHour;
    private List<Zone> zones;

    public Slot() {
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return Objects.equals(startHour, slot.startHour) && Objects.equals(endHour, slot.endHour) && Objects.equals(zones, slot.zones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startHour, endHour, zones);
    }
}
