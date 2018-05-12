package com.yourname.model;

import lombok.Data;

import java.math.BigInteger;
@Data
public class StudentModel {
    private BigInteger id;
    private String name;
    private String course;

}
