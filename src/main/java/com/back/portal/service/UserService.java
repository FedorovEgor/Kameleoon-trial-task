package com.back.portal.service;

import com.back.portal.dto.UserDto;
import com.back.portal.dto.UserRegistrationRequestDto;
import com.back.portal.enums.ErrorMessagesEnum;
import com.back.portal.exception.RegistrationException;
import com.back.portal.exception.UserNotFoundException;
import com.back.portal.mapper.UserMapper;
import com.back.portal.model.UserEntity;
import com.back.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    UserMapper userMapper = UserMapper.INSTANCE;

    @Transactional
    public void saveUser(UserRegistrationRequestDto userDto) {
        if (userRepository.findEmailRepetition(userDto.getEmail()) > 0) {
            throw new RegistrationException(ErrorMessagesEnum.USER_ALREADY_EXISTS.value);
        }
        UserEntity userEntity = userMapper.toUseEntityFromRegistration(userDto);
        userRepository.save(userEntity);
    }

    @Transactional
    public UserDto getUserInfoById(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(ErrorMessagesEnum.NO_USER_FOUND.value));

        return userMapper.toUserDto(userEntity);
    }

    @Transactional
    public List<UserDto> selectAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userMapper.toUserDtoList(userEntities);
    }
}
