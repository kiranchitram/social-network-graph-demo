package com.example.socialnetwork.controller;

import com.example.socialnetwork.model.User;
import com.example.socialnetwork.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // Direct friends
    @GetMapping("/{name}/friends")
    public List<User> getFriends(@PathVariable String name) {
        try {
            return repo.findFriendsByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Database unreachable. Please try again later.");
        }
    }

    // Friends of friends
    @GetMapping("/{name}/friends-of-friends")
    public List<User> getFriendsOfFriends(@PathVariable String name) {
        try {
            return repo.findFriendsOfFriends(name);
        } catch (Exception e) {
            throw new RuntimeException("Database unreachable. Please try again later.");
        }
    }

    // Mutual friends between two users
    @GetMapping("/{name}/mutual/{other}")
    public List<User> getMutualFriends(@PathVariable String name, @PathVariable String other) {
        try {
            return repo.findMutualFriends(name, other);
        } catch (Exception e) {
            throw new RuntimeException("Database unreachable. Please try again later.");
        }
    }

    // Shortest path between two users
    @GetMapping("/{name}/path/{target}")
    public List<User> getShortestPath(@PathVariable String name, @PathVariable String target) {
        try {
            return repo.findShortestPath(name, target);
        } catch (Exception e) {
            throw new RuntimeException("Database unreachable. Please try again later.");
        }
    }

    // Create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        try {
            return repo.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Database unreachable. Could not save user.");
        }
    }
}
