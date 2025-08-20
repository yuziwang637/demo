package com.example.laboratory.service;

import com.example.laboratory.entity.InterviewStudent;

import java.util.List;

public interface InterviewStudentService {
    // 添加面试学生
    int addInterviewStudent(InterviewStudent interviewStudent);

    // 删除面试学生
    int deleteInterviewStudent(Long id);

    // 更新面试学生
    int updateInterviewStudent(InterviewStudent interviewStudent);

    // 根据ID查询面试学生
    InterviewStudent getInterviewStudentById(Long id);

    // 查询所有面试学生
    List<InterviewStudent> getAllInterviewStudents();

    // 根据姓名模糊查询面试学生
    List<InterviewStudent> getInterviewStudentsByName(String name);

    // 根据日期查询面试学生
    List<InterviewStudent> getInterviewStudentsByDate(String date);
}