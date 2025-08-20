package com.example.laboratory.service;

import com.example.laboratory.dto.InterviewResultDTO;
import com.example.laboratory.entity.InterviewResult;

import java.util.List;

public interface InterviewResultService {
    // 添加面试结果
    int addInterviewResult(InterviewResult interviewResult);

    // 删除面试结果
    int deleteInterviewResult(Long id);

    // 更新面试结果
    int updateInterviewResult(InterviewResult interviewResult);

    // 根据ID查询面试结果
    InterviewResult getInterviewResultById(Long id);

    // 查询所有面试结果
    List<InterviewResult> getAllInterviewResults();

    // 根据学生ID查询面试结果
    List<InterviewResult> getInterviewResultsByStudentId(Long studentId);

    // 根据面试状态查询面试结果
    List<InterviewResult> getInterviewResultsByStatus(String status);

    // 查询所有面试结果及学生详细信息
    List<InterviewResultDTO> getAllInterviewResultsWithStudentInfo();

    // 根据学生ID查询面试结果及学生详细信息
    List<InterviewResultDTO> getInterviewResultsByStudentIdWithStudentInfo(Long studentId);

    // 根据面试状态查询面试结果及学生详细信息
    List<InterviewResultDTO> getInterviewResultsByStatusWithStudentInfo(String status);

    // 根据ID查询面试结果及学生详细信息
    InterviewResultDTO getInterviewResultByIdWithStudentInfo(Long id);
}