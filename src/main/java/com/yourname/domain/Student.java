package com.yourname.domain;

import com.yourname.model.StudentModel;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @NotBlank
    @Size(min = 6, max = 30)
    private String name;

    @Column
    @NotBlank
    @NotNull
    @Size(max = 20)
    private String course;

    public StudentModel toStudentModel() {
        StudentModel st = new StudentModel();
        st.setId(id);
        st.setName(name);
        st.setCourse(course);
        return st;
    }
}
