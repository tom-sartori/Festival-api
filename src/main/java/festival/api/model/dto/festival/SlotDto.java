package festival.api.model.dto.festival;

import festival.api.model.collection.festival.Slot;

import java.util.List;
import java.util.Objects;

public class SlotDto {
    private String startHour;
    private String endHour;
    private List<ZoneDto> zones;

    public SlotDto() {
    }

    public SlotDto(Slot slot, List<ZoneDto> zoneDtoList) {
        this.startHour = slot.getStartHour();
        this.endHour = slot.getEndHour();
        this.zones = zoneDtoList;
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

    public List<ZoneDto> getZones() {
        return zones;
    }

    public void setZones(List<ZoneDto> zones) {
        this.zones = zones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotDto slotDto = (SlotDto) o;
        return Objects.equals(startHour, slotDto.startHour) && Objects.equals(endHour, slotDto.endHour) && Objects.equals(zones, slotDto.zones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startHour, endHour, zones);
    }
}
