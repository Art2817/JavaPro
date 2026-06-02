package com.example.controller;

import com.example.dto.UserDTO;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserPostService service;

    public UserController(UserPostService service) {
        this.service = service;
    }

    @PostMapping
    public UserDTO create(@RequestBody User user) {
        return UserMapper.toDTO(service.createUser(user));
    }

    @GetMapping("/name/{name}")
    public List<UserDTO> byName(@PathVariable String name) {
        return service.getByName(name)
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    @GetMapping("/email/{domain}")
    public List<UserDTO> byEmail(@PathVariable String domain) {
        return service.getByEmailDomain(domain)
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }
}