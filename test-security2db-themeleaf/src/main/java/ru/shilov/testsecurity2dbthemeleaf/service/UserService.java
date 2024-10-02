package ru.shilov.testsecurity2dbthemeleaf.service;

import ru.shilov.testsecurity2dbthemeleaf.dto.UserDto;
import ru.shilov.testsecurity2dbthemeleaf.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
