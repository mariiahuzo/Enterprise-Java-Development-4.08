package com.ironhack.Lab_4_08.Lab_4_08.controllers.interfaces;

import com.ironhack.Lab_4_08.Lab_4_08.controllers.dtos.StudentNameDTO;
import com.ironhack.Lab_4_08.Lab_4_08.models.Spell;
import com.ironhack.Lab_4_08.Lab_4_08.models.Student;
import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.List;

public interface StudentController {
    Student getStudentById(Authentication principal, Long id);
    Student saveStudent(Student student);
    void updateSpellList(Long studentId, List<Spell> spellList);
    void updateStudent(Long studentId, StudentNameDTO studentNameDTO);
    void deleteStudent(Long studentId);
}
