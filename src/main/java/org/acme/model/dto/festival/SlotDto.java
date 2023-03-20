package org.acme.model.dto.festival;

import java.util.List;
import java.util.Objects;

public class SlotDto {
    private String startHour;
    private String endHour;
    private List<ZoneDto> zones;

    public SlotDto() {
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
