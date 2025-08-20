package com.example.laboratory.dto;

import lombok.Data;

@Data
public class InterviewResultDTO {
    private Long id;
    private Long studentId;
    private String studentName;
    private String interviewStatus;
    
    // 学生详细信息
    private String studentNumber;  // 学号
    private String major;          // 专业
    private String phone;          // 电话
    private String email;          // 邮箱
}