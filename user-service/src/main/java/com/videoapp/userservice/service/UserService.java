package com.videoapp.userservice.service;

import com.videoapp.userservice.repo.UserRepo;
import com.videoapp.userservice.repo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;


    public List<User> fetchAll()
    {
        return userRepo.findAll();
    }

    public User fetchById(long id)  throws IllegalArgumentException
    {
        return userRepo.getById(id);
    }

    public long create(String name, String email, int subscribers) throws IllegalArgumentException
    {
        final User user = new User(name, email, subscribers);
        final User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    public void update(long id, String name, String email, int subscribers)
    {
        final User user = userRepo.getById(id);
        user.setName(name);
        user.setEmail(email);
        user.setSubscribers(subscribers);
        userRepo.save(user);
    }

    public void delete(long id)
    {
        userRepo.deleteById(id);
    }
}
