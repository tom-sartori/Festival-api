package festival.api.model.dto.festival;

import festival.api.model.collection.festival.Day;

import java.util.List;
import java.util.Objects;

public class DayDto {
    private String name;
    private String startHour;
    private String endHour;
    private List<SlotDto> slots;

    public DayDto() {
    }

    public DayDto(Day day, List<SlotDto> slotDtoList) {
        this.name = day.getName();
        this.startHour = day.getStartHour();
        this.endHour = day.getEndHour();
        this.slots = slotDtoList;
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

    public List<SlotDto> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDto> slots) {
        this.slots = slots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayDto dayDto = (DayDto) o;
        return Objects.equals(name, dayDto.name) && Objects.equals(startHour, dayDto.startHour) && Objects.equals(endHour, dayDto.endHour) && Objects.equals(slots, dayDto.slots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startHour, endHour, slots);
    }
}
