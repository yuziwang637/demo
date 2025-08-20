package com.example.laboratory.entity;

import lombok.Data;

@Data
public class InterviewStudent {
    private Long id;
    private String name;
    private String position;
    private String date;
    private String startTime;
    private String endTime;
    private String interviewers;
}