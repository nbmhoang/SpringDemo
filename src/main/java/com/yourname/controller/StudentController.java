package com.yourname.controller;

import com.yourname.domain.Student;
import com.yourname.exception.NotFoundException;
import com.yourname.model.StudentModel;
import com.yourname.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

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
    public StudentModel getById(@PathVariable("id") BigInteger id) {
        return this.studentService.getById(id).map(Student::toStudentModel).orElseThrow(NotFoundException::new);
    }
}
