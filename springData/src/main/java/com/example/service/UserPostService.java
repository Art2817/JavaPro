package com.example.service;

import com.example.model.*;
import com.example.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserPostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserPostService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Post createPost(Post newPost) {
        Long userId = newPost.getUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("ID" + userId + " dont exist"));
        newPost.setUser(user);
        return postRepository.save(newPost);
    }

    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getByEmailDomain(String domain) {
        return userRepository.findByEmailEndingWith(domain);
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Transactional
    public void createUserWithPost(User user, Post post) {
        userRepository.save(user);

        post.setUser(user);
        postRepository.save(post);

        if (post.getTitle().equals("error")) {
            throw new RuntimeException("Rollback test");
        }
    }

}