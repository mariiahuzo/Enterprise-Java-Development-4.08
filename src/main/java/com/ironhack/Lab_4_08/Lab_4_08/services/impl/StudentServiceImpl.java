package com.ironhack.Lab_4_08.Lab_4_08.services.impl;

import com.ironhack.Lab_4_08.Lab_4_08.controllers.dtos.StudentNameDTO;
import com.ironhack.Lab_4_08.Lab_4_08.models.Spell;
import com.ironhack.Lab_4_08.Lab_4_08.models.Student;
import com.ironhack.Lab_4_08.Lab_4_08.repositories.StudentRepository;
import com.ironhack.Lab_4_08.Lab_4_08.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }

        return studentOptional.get();
    }

    public Student saveStudent(Student student) {
        //student.setId(null);
        if (student.getId() != null && studentRepository.existsById(student.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + student.getId() + " already exists for another Student");
        }
        return studentRepository.save(student);
    }

    public void updateSpellList(Long studentId, List<Spell> spellList) {
        Student student = getStudentById(studentId);

        student.setSpellList(spellList);

        studentRepository.save(student);
    }

    public void updateStudent(Long studentId, StudentNameDTO studentNameDTO) {
        Student student = getStudentById(studentId);

        student.setFirstName(studentNameDTO.getFirstName());
        student.setLastName(studentNameDTO.getLastName());

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Student student = getStudentById(studentId);

        studentRepository.delete(student);
    }
}
