package com.modsen.library.wrapper;

import com.modsen.library.configuration.jwt.JwtTokenProvider;
import com.modsen.library.dto.user.AuthDto;
import com.modsen.library.dto.user.TokenDto;
import com.modsen.library.dto.user.UserDto;
import com.modsen.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static com.modsen.library.mapper.UserMapper.INSTANCE;

@Component
@RequiredArgsConstructor
public class UserWrapper {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserDto save(UserDto userDto, BindingResult bindingResult) {
        return INSTANCE.userToDto(
                userService.save(
                        INSTANCE.dtoToUser(userDto), bindingResult));
    }

    public TokenDto login(AuthDto authDto, BindingResult bindingResult) {
        User user = userService.login(INSTANCE.authDtoToUser(authDto), bindingResult);
        return INSTANCE.stringToTokenDto(
                jwtTokenProvider.generateToken(user.getUsername(), user.getRoles()));
    }
}