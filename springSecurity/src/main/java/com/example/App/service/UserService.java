package com.example.App.service;

import com.example.App.dto.UserDto;
import com.example.App.model.User;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}