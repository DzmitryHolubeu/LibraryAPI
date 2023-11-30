package com.modsen.library.mapper;

import com.modsen.library.dto.user.AuthDto;
import com.modsen.library.dto.user.TokenDto;
import com.modsen.library.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToUser(UserDto dto);

    UserDto userToDto(User user);

    User authDtoToUser(AuthDto dto);

    TokenDto stringToTokenDto(String token);
}