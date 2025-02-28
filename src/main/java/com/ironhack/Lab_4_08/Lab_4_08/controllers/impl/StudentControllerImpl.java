package com.ironhack.Lab_4_08.Lab_4_08.controllers.impl;

import com.ironhack.Lab_4_08.Lab_4_08.controllers.dtos.StudentNameDTO;
import com.ironhack.Lab_4_08.Lab_4_08.controllers.interfaces.StudentController;
import com.ironhack.Lab_4_08.Lab_4_08.models.Spell;
import com.ironhack.Lab_4_08.Lab_4_08.models.Student;
import com.ironhack.Lab_4_08.Lab_4_08.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{studentId}")
    public Student getStudentById(Authentication authentication, @PathVariable(name = "studentId") Long id) {
        System.out.println(authentication.getName());
        System.out.println(authentication.getCredentials());
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent( @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PatchMapping("/student/spell/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSpellList(@PathVariable Long studentId, @RequestBody List<Spell> spellList) {
        studentService.updateSpellList(studentId, spellList);
    }

    @PatchMapping("/student/name/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable Long studentId, @RequestBody @Valid StudentNameDTO studentNameDTO) {
        studentService.updateStudent(studentId, studentNameDTO);
    }

    @DeleteMapping("/student/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
