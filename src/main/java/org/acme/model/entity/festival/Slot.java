package org.acme.model.entity.festival;

import java.util.Arrays;
import java.util.Objects;

public class Slot {

    private String startHour;
    private String endHour;
    private Zone[] zones;

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

    public Zone[] getZones() {
        return zones;
    }

    public void setZones(Zone[] zones) {
        this.zones = zones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return Objects.equals(startHour, slot.startHour) && Objects.equals(endHour, slot.endHour) && Arrays.equals(zones, slot.zones);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(startHour, endHour);
        result = 31 * result + Arrays.hashCode(zones);
        return result;
    }
}
