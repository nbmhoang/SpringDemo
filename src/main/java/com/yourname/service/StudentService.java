package com.yourname.service;

import com.yourname.constant.MessageConstant;
import com.yourname.exception.NotFoundException;
import com.yourname.model.StudentForm;
import com.yourname.domain.Student;
import com.yourname.model.StudentModel;
import com.yourname.repository.StudentRepository;
import com.yourname.service.provider.StudentServiceInterface;
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
public class StudentService implements StudentServiceInterface {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> getAllStudents(){
        List<StudentModel> rs = new ArrayList<>();
        this.studentRepository.findAll().forEach(student -> {
            rs.add(student.toStudentModel());
        });
        return rs;
    }

    @Override
    public StudentModel getStudentById(long id) {
        //System.out.println("=========>" + id);
        return this.studentRepository.getStudentById(id).map(Student::toStudentModel).orElseThrow(NotFoundException::new);
    }

    @Override
    public StudentModel createStudent(StudentForm studentForm) {
        Student st = new Student();
        st.setName(studentForm.getName());
        st.setCourse(studentForm.getCourse());

        return this.studentRepository.save(st).toStudentModel();
    }

    @Override
    public void updateStudentById(long id, StudentForm studentForm) {
        this.studentRepository.getStudentById(id).map(student -> {
            student.setName(studentForm.getName());
            student.setCourse(studentForm.getCourse());
            return this.studentRepository.save(student);
        }).orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteStudentById(long id) {
        Student student = this.studentRepository.getStudentById(id).orElseThrow(NotFoundException::new);
        this.studentRepository.delete(student);
    }
}
