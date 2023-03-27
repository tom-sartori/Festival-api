package festival.api.model.mapper;

import festival.api.model.collection.user.User;
import festival.api.model.dto.user.UserDto;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(user);
    }

    public List<UserDto> toDto(List<User> userList) {
        List<UserDto> list = new ArrayList<>();
        for (User user : userList) {
            UserDto toDto = toDto(user);
            list.add(toDto);
        }
        return list;
    }
}
