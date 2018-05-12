package com.yourname.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yourname.model.StudentModel;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private String name;
    private String course;
    public StudentModel toStudentModel() {
        StudentModel st = new StudentModel();
        st.setId(id);
        st.setName(name);
        st.setCourse(course);
        return st;
    }
}
