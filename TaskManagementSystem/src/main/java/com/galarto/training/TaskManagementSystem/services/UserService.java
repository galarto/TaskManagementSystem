package com.galarto.training.TaskManagementSystem.services;

import com.galarto.training.TaskManagementSystem.models.User;
import com.galarto.training.TaskManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        if (savedUser != null) {
            return savedUser;
        }

        return null;
    }

    public User findUserById(int id) {

        if (userRepository.existsById(id)) {
            return userRepository.findById(id).get();
        }

        return null;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}

