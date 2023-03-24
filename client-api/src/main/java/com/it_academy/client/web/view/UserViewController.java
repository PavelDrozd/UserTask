package com.it_academy.client.web.view;

import com.it_academy.data.dto.user.UserDto;
import com.it_academy.service.serv.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserViewController {

    private static final String ATTR_USER = "user";
    private static final String USER_PAGE = "user/user";
    private static final String USERS_PAGE = "user/users";
    private static final String REGISTER_PAGE = "user/register";
    private static final String EDIT_PAGE = "user/edit";

    private final UserService userService;

    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        UserDto user = userService.get(id);
        model.addAttribute(ATTR_USER, user);
        return USER_PAGE;
    }

    @GetMapping()
    public String getAll() {
        return USERS_PAGE;
    }

    @GetMapping("/register")
    public String register(){
        return REGISTER_PAGE;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        UserDto user = userService.get(id);
        model.addAttribute(ATTR_USER, user);
        return EDIT_PAGE;
    }

}
