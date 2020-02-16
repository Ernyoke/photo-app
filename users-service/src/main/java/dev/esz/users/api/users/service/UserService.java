package dev.esz.users.api.users.service;

import dev.esz.users.api.users.data.UserEntity;
import dev.esz.users.api.users.repository.UserRepository;
import dev.esz.users.api.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserService(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPassword("test");
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return modelMapper.map(savedUserEntity, UserDto.class);
    }
}
