package com.videoapp.userservice.api;


import com.videoapp.userservice.repo.model.User;
import com.videoapp.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    public final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> index()
    {
        final List<User> users = userService.fetchAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> show(@PathVariable long id) {
        try {
            final User user = userService.fetchById(id);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.videoapp.userservice.api.dto.User user)
    {
        final String name = user.getName();
        final String email = user.getEmail();
        final int subscribers = user.getSubscribers();
        final long id = userService.create(name, email, subscribers);
        final String location = String.format("/user/%d", id);


        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.videoapp.userservice.api.dto.User user)
    {
        final String name = user.getName();
        final String email = user.getEmail();
        final int subscribers = user.getSubscribers();
        userService.update(id, name, email, subscribers);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id)
    {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
