package com.ironhack.Lab_4_08.Lab_4_08.repositories;


import com.ironhack.Lab_4_08.Lab_4_08.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
