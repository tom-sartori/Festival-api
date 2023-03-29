package festival.api.model.dto.festival;

import festival.api.model.collection.festival.Festival;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FestivalDto {

    private String id;
    private String name;
    private String startDate;
    private boolean active;
    private List<DayDto> days;

    public FestivalDto() {
    }

    public FestivalDto(Festival festival, List<DayDto> dayDtoList) {
        this.id = festival.getId().toString();
        this.name = festival.getName();
        this.startDate = festival.getStartDate();
        this.active = festival.isActive();
        this.days = dayDtoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<DayDto> getDays() {
        return days;
    }

    public void setDays(List<DayDto> days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FestivalDto that = (FestivalDto) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate) && Objects.equals(days, that.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, active, days);
    }
}
