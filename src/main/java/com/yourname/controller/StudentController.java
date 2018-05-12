package com.yourname.controller;

import com.yourname.domain.Student;
import com.yourname.model.StudentModel;
import com.yourname.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<StudentModel> getAll(){
        return this.studentService.getAll();
    }
    @RequestMapping(value = ("/{id}"), method = RequestMethod.GET)
    public Optional<Student> getById(BigInteger id) {
        return this.studentService.getById(id);
    }
}
