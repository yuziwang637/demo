package com.example.laboratory.controller;

import com.example.laboratory.entity.InterviewResult;
import com.example.laboratory.service.InterviewResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/interview-result")
@Tag(name = "面试结果管理", description = "面试结果相关的API接口")
public class InterviewResultController {

    @Autowired
    private InterviewResultService interviewResultService;

    @Operation(summary = "添加面试结果", description = "创建新的面试结果")
    @PostMapping
    public Map<String, Object> addInterviewResult(@RequestBody InterviewResult interviewResult) {
        Map<String, Object> result = new HashMap<>();
        int count = interviewResultService.addInterviewResult(interviewResult);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "添加面试结果成功");
        } else {
            result.put("success", false);
            result.put("message", "添加面试结果失败");
        }
        return result;
    }

    @Operation(summary = "删除面试结果", description = "根据ID删除面试结果")
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteInterviewResult(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        int count = interviewResultService.deleteInterviewResult(id);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "删除面试结果成功");
        } else {
            result.put("success", false);
            result.put("message", "删除面试结果失败");
        }
        return result;
    }

    @Operation(summary = "更新面试结果", description = "修改面试结果信息")
    @PutMapping
    public Map<String, Object> updateInterviewResult(@RequestBody InterviewResult interviewResult) {
        Map<String, Object> result = new HashMap<>();
        int count = interviewResultService.updateInterviewResult(interviewResult);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "更新面试结果成功");
        } else {
            result.put("success", false);
            result.put("message", "更新面试结果失败");
        }
        return result;
    }



    @Operation(summary = "获取所有面试结果", description = "查询所有面试结果信息（包含学生详细信息）")
    @GetMapping
    public List<?> getAllInterviewResults() {
        return interviewResultService.getAllInterviewResultsWithStudentInfo();
    }

    @Operation(summary = "根据学生ID查询面试结果", description = "根据学生ID查询面试结果信息（包含学生详细信息）")
    @GetMapping("/student/{studentId}")
    public List<?> getInterviewResultsByStudentId(@PathVariable Long studentId) {
        return interviewResultService.getInterviewResultsByStudentIdWithStudentInfo(studentId);
    }

    @Operation(summary = "根据面试状态查询面试结果", description = "根据面试状态查询面试结果信息（包含学生详细信息）")
    @GetMapping("/status/{status}")
    public List<?> getInterviewResultsByStatus(@PathVariable String status) {
        return interviewResultService.getInterviewResultsByStatusWithStudentInfo(status);
    }
}