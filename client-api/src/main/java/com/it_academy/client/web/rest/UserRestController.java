package com.it_academy.client.web.rest;

import com.it_academy.exception.controller.ValidationException;
import com.it_academy.data.dto.user.UserDto;
import com.it_academy.service.serv.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping
    public Page<UserDto> getAll(Pageable pageable) {
        return userService.getAll(pageable);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto user, HttpSession session, Errors errors) {
        checkErrors(errors);
        UserDto created = userService.create(user);
        session.setAttribute("user", created);
        return buildResponseUser(created);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody @Valid UserDto user, Errors errors) {
        checkErrors(errors);
        user.setId(id);
        return userService.update(user);
    }

    @PatchMapping("/{id}")
    public UserDto updatePart(@PathVariable Long id, @RequestBody @Valid UserDto user) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    private void checkErrors(Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
    }

    private ResponseEntity<UserDto> buildResponseUser(UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(getLocation(user))
                .body(user);
    }

    private URI getLocation(UserDto user) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();
    }

}
