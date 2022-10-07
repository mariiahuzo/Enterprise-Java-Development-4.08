package com.ironhack.Lab_4_08.Lab_4_08.services.interfaces;

import com.ironhack.Lab_4_08.Lab_4_08.controllers.dtos.StudentNameDTO;
import com.ironhack.Lab_4_08.Lab_4_08.models.Spell;
import com.ironhack.Lab_4_08.Lab_4_08.models.Student;
import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    Student saveStudent(Student student);

    void updateSpellList(Long studentId, List<Spell> spellList);

    void updateStudent(Long studentId, StudentNameDTO studentNameDTO);

    void deleteStudent(Long studentId);
}
