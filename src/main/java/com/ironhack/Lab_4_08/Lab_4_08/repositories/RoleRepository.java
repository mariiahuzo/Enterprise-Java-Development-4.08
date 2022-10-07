package com.ironhack.Lab_4_08.Lab_4_08.repositories;

import com.ironhack.Lab_4_08.Lab_4_08.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
