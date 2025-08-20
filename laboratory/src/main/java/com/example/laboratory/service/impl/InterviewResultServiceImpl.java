package com.example.laboratory.service.impl;

import com.example.laboratory.dto.InterviewResultDTO;
import com.example.laboratory.entity.InterviewResult;
import com.example.laboratory.mapper.InterviewResultMapper;
import com.example.laboratory.service.InterviewResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewResultServiceImpl implements InterviewResultService {

    @Autowired
    private InterviewResultMapper interviewResultMapper;

    @Override
    public int addInterviewResult(InterviewResult interviewResult) {
        return interviewResultMapper.insert(interviewResult);
    }

    @Override
    public int deleteInterviewResult(Long id) {
        return interviewResultMapper.deleteById(id);
    }

    @Override
    public int updateInterviewResult(InterviewResult interviewResult) {
        return interviewResultMapper.update(interviewResult);
    }

    @Override
    public InterviewResult getInterviewResultById(Long id) {
        return interviewResultMapper.selectById(id);
    }

    @Override
    public List<InterviewResult> getAllInterviewResults() {
        return interviewResultMapper.selectAll();
    }

    @Override
    public List<InterviewResult> getInterviewResultsByStudentId(Long studentId) {
        return interviewResultMapper.selectByStudentId(studentId);
    }

    @Override
    public List<InterviewResult> getInterviewResultsByStatus(String status) {
        return interviewResultMapper.selectByStatus(status);
    }

    @Override
    public List<InterviewResultDTO> getAllInterviewResultsWithStudentInfo() {
        return interviewResultMapper.selectAllWithStudentInfo();
    }

    @Override
    public List<InterviewResultDTO> getInterviewResultsByStudentIdWithStudentInfo(Long studentId) {
        return interviewResultMapper.selectByStudentIdWithStudentInfo(studentId);
    }

    @Override
    public List<InterviewResultDTO> getInterviewResultsByStatusWithStudentInfo(String status) {
        return interviewResultMapper.selectByStatusWithStudentInfo(status);
    }

    @Override
    public InterviewResultDTO getInterviewResultByIdWithStudentInfo(Long id) {
        return interviewResultMapper.selectByIdWithStudentInfo(id);
    }
}