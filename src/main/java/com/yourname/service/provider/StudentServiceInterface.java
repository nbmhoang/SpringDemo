package com.yourname.service.provider;

import com.yourname.domain.Student;
import com.yourname.model.StudentForm;
import com.yourname.model.StudentModel;

import java.util.List;
import java.util.Optional;

public abstract interface StudentServiceInterface {
    public abstract List<StudentModel> getAllStudents();
    public abstract StudentModel getStudentById(long id);
    public abstract StudentModel createStudent(StudentForm studentForm);
    public abstract void updateStudentById(long id, StudentForm studentForm);
    public abstract void deleteStudentById(long id);
}
