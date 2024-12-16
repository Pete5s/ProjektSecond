package com.example.Genesis.Project.repository;

import com.example.Genesis.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPersonID(String personID);



}
