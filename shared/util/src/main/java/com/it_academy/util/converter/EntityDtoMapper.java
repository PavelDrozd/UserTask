package com.it_academy.util.converter;


import com.it_academy.data.dto.user.UserDto;
import com.it_academy.store.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityDtoMapper {
    private final ModelMapper mapper;

    public UserDto mapToUserDto(User user) {
        return mapper.map(user, UserDto.class);
    }

    public User mapToUser(UserDto userDto) {
        return mapper.map(userDto, User.class);
    }

}
