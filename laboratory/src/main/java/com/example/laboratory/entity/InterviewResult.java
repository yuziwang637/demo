package com.example.laboratory.entity;

import lombok.Data;

@Data
public class InterviewResult {
    private Long id;
    private Long studentId;
    private String studentName;
    private String interviewStatus;
}