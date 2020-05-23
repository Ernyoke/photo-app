package dev.esz.users.api.users.controller;

import dev.esz.users.api.users.model.CreateUserRequestModel;
import dev.esz.users.api.users.model.CreateUserResponseModel;
import dev.esz.users.api.users.service.UserService;
import dev.esz.users.api.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final Environment environment;

    public UserController(UserService userService, ModelMapper modelMapper, Environment environment) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.environment = environment;
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel) {
        UserDto userDto = modelMapper.map(createUserRequestModel, UserDto.class);
        CreateUserResponseModel createUserResponseModel =
                modelMapper.map(userService.createUser(userDto), CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponseModel);
    }

    @GetMapping("/secret")
    public String getSecret() {
        return environment.getProperty("token.secret");
    }

}
