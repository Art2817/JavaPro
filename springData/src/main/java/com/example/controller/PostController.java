package com.example.controller;

import com.example.dto.PostDTO;
import com.example.model.Post;
import com.example.service.UserPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final UserPostService service;

    public PostController(UserPostService service) {
        this.service = service;
    }

    @GetMapping("/user/{userId}")
    public List<Post> getByUser(@PathVariable Long userId) {
        return service.getPostsByUserId(userId);
    }

    @PostMapping
    public PostDTO createPost(@RequestBody Post post) {
        Post saved = service.createPost(post);

        PostDTO dto = new PostDTO();
        dto.id = saved.getId();
        dto.title = saved.getTitle();
        dto.content = saved.getContent();

        return dto;
    }
}