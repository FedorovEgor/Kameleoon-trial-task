package com.back.portal.mapper;

import com.back.portal.dto.UserDto;
import com.back.portal.dto.UserRegistrationRequestDto;
import com.back.portal.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

   UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

   UserEntity toUserEntity(UserDto userDto);
   UserEntity toUseEntityFromRegistration(UserRegistrationRequestDto userRegistrationRequestDto);
   //@Mapping(target = "registrationDate", dateFormat = "dd-MM-yyyy")
   UserDto toUserDto(UserEntity userEntity);
   List<UserDto> toUserDtoList(List<UserEntity> userEntities);
}
