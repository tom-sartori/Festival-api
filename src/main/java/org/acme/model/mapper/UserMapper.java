package org.acme.model.mapper;

import org.acme.model.dto.user.UserDto;
import org.acme.model.collection.user.User;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(user);
    }

    public List<UserDto> toDto(List<User> userList) {
        return userList.stream().map(this::toDto).toList();
    }
}
