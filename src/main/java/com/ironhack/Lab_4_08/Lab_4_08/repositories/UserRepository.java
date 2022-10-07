package com.ironhack.Lab_4_08.Lab_4_08.repositories;

import com.ironhack.Lab_4_08.Lab_4_08.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
