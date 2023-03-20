package org.acme.model.entity.festival;

import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class festival {

    private ObjectId id;
    private String name;
    private Date startDate;
    private boolean isActive;
    private Day[] days;

    public festival() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        festival festival = (festival) o;
        return isActive == festival.isActive && Objects.equals(id, festival.id) && Objects.equals(name, festival.name) && Objects.equals(startDate, festival.startDate) && Arrays.equals(days, festival.days);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, startDate, isActive);
        result = 31 * result + Arrays.hashCode(days);
        return result;
    }
}
