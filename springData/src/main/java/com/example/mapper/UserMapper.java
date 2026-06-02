package com.example.mapper;

import com.example.dto.*;
import com.example.model.*;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(User user) {

        UserDTO dto = new UserDTO();
        dto.id = user.getId();
        dto.name = user.getName();
        dto.email = user.getEmail();

        dto.posts = user.getPosts().stream().map(post -> {
            PostDTO p = new PostDTO();
            p.id = post.getId();
            p.title = post.getTitle();
            p.content = post.getContent();
            return p;
        }).collect(Collectors.toList());

        return dto;
    }
}