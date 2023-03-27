package festival.api.model.mapper;

import festival.api.model.collection.festival.Day;
import festival.api.model.collection.festival.Festival;
import festival.api.model.collection.festival.Slot;
import festival.api.model.collection.festival.Zone;
import festival.api.model.collection.user.User;
import festival.api.model.dto.festival.*;
import festival.api.repository.UserRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FestivalMapper {

    @Inject
    UserRepository userRepository;

    public FestivalDto toDto(Festival festival) {
        List<User> userList = userRepository.listAll();

        List<DayDto> dayDtoList = new ArrayList<>();
        for (Day day : festival.getDays()) {

            List<SlotDto> slotDtoList = new ArrayList<>();
            for (Slot slot : day.getSlots()) {

                List<ZoneDto> zoneDtoList = new ArrayList<>();
                for (Zone zone : slot.getZones()) {

                    List<VolunteerDto> volunteerDtoList = new ArrayList<>();
                    for (ObjectId volunteerRef : zone.getVolunteerRefs()) {
                        userList.stream()
                                .filter(u -> u.getId().equals(volunteerRef))
                                .findFirst()
                                .ifPresent(user -> volunteerDtoList.add(new VolunteerDto(user)));
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
        List<FestivalDto> list = new ArrayList<>();
        for (Festival festival : festivalList) {
            FestivalDto festivalDto = toDto(festival);
            list.add(festivalDto);
        }
        return list;
    }

    public Festival toEntity(FestivalDto festivalDto) {
        List<Day> dayList = new ArrayList<>();
        for (DayDto dayDto : festivalDto.getDays()) {

            List<Slot> slotList = new ArrayList<>();
            for (SlotDto slotDto : dayDto.getSlots()) {

                List<Zone> zoneList = new ArrayList<>();
                for (ZoneDto zoneDto : slotDto.getZones()) {

                    List<ObjectId> volunteerRefList = new ArrayList<>();
                    for (VolunteerDto volunteerDto : zoneDto.getVolunteers()) {
                        volunteerRefList.add(volunteerDto.getId());
                    }
                    zoneList.add(new Zone(zoneDto, volunteerRefList));
                }
                slotList.add(new Slot(slotDto, zoneList));
            }
            dayList.add(new Day(dayDto, slotList));
        }

        return new Festival(festivalDto, dayList);
    }
}
