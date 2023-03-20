package org.acme.mapper;

import org.acme.model.dto.festival.*;
import org.acme.model.entity.User;
import org.acme.model.entity.festival.Day;
import org.acme.model.entity.festival.Festival;
import org.acme.model.entity.festival.Slot;
import org.acme.model.entity.festival.Zone;
import org.acme.repository.UserRepository;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class FestivalMapper {

    @Inject
    UserRepository userRepository;

    public FestivalDto toDto(Festival festival) {
        List<DayDto> dayDtoList = new ArrayList<>();
        for (Day day : festival.getDays()) {

            List<SlotDto> slotDtoList = new ArrayList<>();
            for (Slot slot : day.getSlots()) {

                List<ZoneDto> zoneDtoList = new ArrayList<>();
                for (Zone zone : slot.getZones()) {

                    List<VolunteerDto> volunteerDtoList = new ArrayList<>();
                    for (ObjectId volunteerRef : zone.getVolunteerRefs()) {
                        User user = userRepository.findById(volunteerRef);
                        if (user != null) {
                            VolunteerDto volunteerDto = new VolunteerDto(user);
                            volunteerDtoList.add(volunteerDto);
                        }
                    }
                    zoneDtoList.add(new ZoneDto(zone, volunteerDtoList));
                }
                slotDtoList.add(new SlotDto(slot, zoneDtoList));
            }
            dayDtoList.add(new DayDto(day, slotDtoList));
        }

        return new FestivalDto(festival, dayDtoList);
    }

    public List<FestivalDto> toDto(List<Festival> festivalList) {
        return festivalList.stream().map(this::toDto).toList();
    }
}
