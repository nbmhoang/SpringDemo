package com.yourname.controller;

import com.yourname.constant.APIConfig;
import com.yourname.model.StudentForm;
import com.yourname.model.StudentModel;
import com.yourname.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIConfig.PREFIX)
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(APIConfig.URI_STUDENT_ALL)
    public List<StudentModel> getAll(){
        return this.studentService.getAllStudents();
    }

    @GetMapping(APIConfig.URI_STUDENT_GETONE)
    public StudentModel getById(@PathVariable("id") long id) {
        return this.studentService.getStudentById(id);
    }

    @PostMapping(APIConfig.URI_STUDENT_CREATE)
    public StudentModel createStudent(@RequestBody StudentForm studentForm) {
        return this.studentService.createStudent(studentForm);
    }

    @PutMapping(APIConfig.URI_STUDENT_UPDATE)
    public ResponseEntity updateStudentById(@PathVariable long id, @RequestBody StudentForm studentForm) {
        this.studentService.updateStudentById(id, studentForm);
        return new ResponseEntity("Updated student!", HttpStatus.OK);
    }

    @DeleteMapping(APIConfig.URI_STUDENT_DELETE)
    public ResponseEntity deleteStudentById(@PathVariable long id) {
        this.studentService.deleteStudentById(id);
        return new ResponseEntity("Deleted student!", HttpStatus.OK);
    }

}
