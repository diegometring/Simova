package com.example.Simova.services;

import com.example.Simova.entity.User;
import com.example.Simova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found by id" + id));
    }

    public User save(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        return userRepository.save(user);
    }

    public User update(User userUpdated, int id) {
        User UserExist = getById(id);
        UserExist.setFirstName(userUpdated.getFirstName());
        UserExist.setLastName(userUpdated.getLastName());
        return userRepository.save(userUpdated);
    }

    public void delete(int id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}
