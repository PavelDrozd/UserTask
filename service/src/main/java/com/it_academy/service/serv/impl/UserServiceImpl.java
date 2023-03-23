package com.it_academy.service.serv.impl;

import com.it_academy.data.dto.UserDto;
import com.it_academy.exception.service.ServiceNotFoundException;
import com.it_academy.exception.service.ServiceValidationException;
import com.it_academy.service.serv.UserService;
import com.it_academy.store.entity.User;
import com.it_academy.store.repository.UserRepository;
import com.it_academy.util.converter.EntityDtoMapper;
import com.it_academy.util.log.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRep;
    private final EntityDtoMapper mapper;

    @Logger
    @Override
    public UserDto create(UserDto userDto) {
        checkUserNull(userDto);
        userDto.setRole(UserDto.Role.CUSTOMER_USER);
        User user = userRep.save(mapper.mapToUser(userDto));
        return mapper.mapToUserDto(user);
    }

    @Logger
    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return userRep.findAll(pageable).map(mapper::mapToUserDto);
    }

    @Logger
    @Override
    public UserDto get(Long id) {
        return userRep.findById(id)
                .map(mapper::mapToUserDto)
                .orElseThrow(() -> new ServiceNotFoundException("User with id " + id + " doesn't exist"));
    }

    @Logger
    @Override
    public UserDto update(UserDto userDto) {
        checkUserNull(userDto);
        User user = userRep.save(mapper.mapToUser(userDto));
        return mapper.mapToUserDto(user);
    }

    @Logger
    @Override
    public void delete(Long id) {
        userRep.findById(id).orElseThrow(() -> new ServiceNotFoundException("User doesn't exist"));
    }

    private static void checkUserNull(UserDto userDto) {
        if (userDto == null) {
            throw new ServiceValidationException("User for create is null");
        }
    }

}
