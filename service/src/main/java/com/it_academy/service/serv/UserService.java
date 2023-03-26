package com.it_academy.service.serv;


import com.it_academy.data.dto.user.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends AbstractService<UserDto, Long> {

    Page<UserDto> getAllSortedByEmail(Pageable pageable);

}
