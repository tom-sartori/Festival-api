package org.acme.model.entity.festival;

import java.util.Arrays;
import java.util.Objects;

public class Day {

    private String name;
    private String startHour;
    private String endHour;
    private Slot[] slots;

    public Day() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return Objects.equals(name, day.name) && Objects.equals(startHour, day.startHour) && Objects.equals(endHour, day.endHour) && Arrays.equals(slots, day.slots);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, startHour, endHour);
        result = 31 * result + Arrays.hashCode(slots);
        return result;
    }
}
