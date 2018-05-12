package com.yourname.service;

import com.yourname.model.StudentForm;
import com.yourname.domain.Student;
import com.yourname.model.StudentModel;
import com.yourname.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //GetByid
    public Optional<Student> getById(BigInteger id) {
        System.out.println("=========>" + id);
        return this.studentRepository.getById(id);
    }
    //GetAll

    public List<StudentModel> getAll(){
        List<StudentModel> rs = new ArrayList<>();
        this.studentRepository.findAll().forEach(student -> {
            rs.add(student.toStudentModel());
        });
        return rs;
    }
}
