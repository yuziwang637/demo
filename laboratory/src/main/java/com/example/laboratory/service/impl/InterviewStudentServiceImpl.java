package com.example.laboratory.service.impl;

import com.example.laboratory.entity.InterviewStudent;
import com.example.laboratory.mapper.InterviewStudentMapper;
import com.example.laboratory.service.InterviewStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewStudentServiceImpl implements InterviewStudentService {

    @Autowired
    private InterviewStudentMapper interviewStudentMapper;

    @Override
    public int addInterviewStudent(InterviewStudent interviewStudent) {
        return interviewStudentMapper.insert(interviewStudent);
    }

    @Override
    public int deleteInterviewStudent(Long id) {
        return interviewStudentMapper.deleteById(id);
    }

    @Override
    public int updateInterviewStudent(InterviewStudent interviewStudent) {
        return interviewStudentMapper.update(interviewStudent);
    }

    @Override
    public InterviewStudent getInterviewStudentById(Long id) {
        return interviewStudentMapper.selectById(id);
    }

    @Override
    public List<InterviewStudent> getAllInterviewStudents() {
        return interviewStudentMapper.selectAll();
    }

    @Override
    public List<InterviewStudent> getInterviewStudentsByName(String name) {
        return interviewStudentMapper.selectByName(name);
    }

    @Override
    public List<InterviewStudent> getInterviewStudentsByDate(String date) {
        return interviewStudentMapper.selectByDate(date);
    }
}