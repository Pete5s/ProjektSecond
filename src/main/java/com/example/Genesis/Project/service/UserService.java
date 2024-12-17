package com.example.Genesis.Project.service;

import com.example.Genesis.Project.model.User;
import com.example.Genesis.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) throws Exception {
        if (userRepository.existsByPersonID(user.getPersonID())) {
            throw new Exception("PersonID already exists!");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User updatedUser) throws Exception {
        Optional<User> userOptional = userRepository.findById(updatedUser.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(updatedUser.getName());
            user.setSurname(updatedUser.getSurname());
            user.setUuid(updatedUser.getUuid());
            return userRepository.save(user);
        } else {
            throw new Exception("User not found");
        }
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String getUserByUuid(String uuid) {
        return null;
    }



}

