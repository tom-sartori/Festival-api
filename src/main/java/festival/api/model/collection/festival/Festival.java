package festival.api.model.collection.festival;

import festival.api.model.dto.festival.FestivalDto;
import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static festival.api.constant.DbCollections.FESTIVAL_COLLECTION;

@MongoEntity(collection = FESTIVAL_COLLECTION)
public class Festival {

    private ObjectId id;
    private String name;
    private String startDate;
    private boolean active;
    private List<Day> days;

    public Festival() {
    }

    public Festival(FestivalDto festivalDto, List<Day> dayList) {
        if (festivalDto.getId() == null || festivalDto.getId().isEmpty()) {
            this.id = null;
        }
        else {
            this.id = new ObjectId(festivalDto.getId());
        }
        this.name = festivalDto.getName();
        this.startDate = festivalDto.getStartDate();
        this.active = festivalDto.isActive();
        this.days = dayList;
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

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Festival festival = (Festival) o;
        return active == festival.active && Objects.equals(id, festival.id) && Objects.equals(name, festival.name) && Objects.equals(startDate, festival.startDate) && Objects.equals(days, festival.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, active, days);
    }
}
