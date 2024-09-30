package com.barbearia_ibertioga.barbearia_api.Controller;

import com.barbearia_ibertioga.barbearia_api.DTO.UserDto;
import com.barbearia_ibertioga.barbearia_api.Service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<UserDto> createNewUser (@RequestBody UserDto user) {
        var newUser =userService.createUser(user);
        return new ResponseEntity(newUser, HttpStatus.CREATED);
    }


}
