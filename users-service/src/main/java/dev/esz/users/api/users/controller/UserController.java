package dev.esz.users.api.users.controller;

import dev.esz.users.api.users.model.CreateUserRequestModel;
import dev.esz.users.api.users.model.CreateUserResponseModel;
import dev.esz.users.api.users.service.UserService;
import dev.esz.users.api.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel) {
        UserDto userDto = modelMapper.map(createUserRequestModel, UserDto.class);
        CreateUserResponseModel createUserResponseModel =
                modelMapper.map(userService.createUser(userDto), CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponseModel);
    }
}
