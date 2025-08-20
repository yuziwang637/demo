package com.example.laboratory.entity;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String password;
    private String name;
    private String major;
    private String studentId;
    private String phone;
    private String email;
}