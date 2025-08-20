package com.example.laboratory.controller;

import com.example.laboratory.entity.InterviewStudent;
import com.example.laboratory.service.InterviewStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/interview-student")
@Tag(name = "面试学生管理", description = "面试学生相关的API接口")
public class InterviewStudentController {

    @Autowired
    private InterviewStudentService interviewStudentService;

    @Operation(summary = "添加面试学生", description = "创建新的面试学生记录")
    @PostMapping
    public Map<String, Object> addInterviewStudent(@RequestBody InterviewStudent interviewStudent) {
        Map<String, Object> result = new HashMap<>();
        int count = interviewStudentService.addInterviewStudent(interviewStudent);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "添加面试学生成功");
        } else {
            result.put("success", false);
            result.put("message", "添加面试学生失败");
        }
        return result;
    }

    @Operation(summary = "删除面试学生", description = "根据ID删除面试学生记录")
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteInterviewStudent(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        int count = interviewStudentService.deleteInterviewStudent(id);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "删除面试学生成功");
        } else {
            result.put("success", false);
            result.put("message", "删除面试学生失败");
        }
        return result;
    }

    @Operation(summary = "更新面试学生", description = "修改面试学生记录信息")
    @PutMapping
    public Map<String, Object> updateInterviewStudent(@RequestBody InterviewStudent interviewStudent) {
        Map<String, Object> result = new HashMap<>();
        int count = interviewStudentService.updateInterviewStudent(interviewStudent);
        if (count > 0) {
            result.put("success", true);
            result.put("message", "更新面试学生成功");
        } else {
            result.put("success", false);
            result.put("message", "更新面试学生失败");
        }
        return result;
    }

    @Operation(summary = "获取面试学生", description = "根据ID查询面试学生记录信息")
    @GetMapping("/{id}")
    public InterviewStudent getInterviewStudentById(@PathVariable Long id) {
        return interviewStudentService.getInterviewStudentById(id);
    }

    @Operation(summary = "获取所有面试学生", description = "查询所有面试学生记录信息")
    @GetMapping
    public List<InterviewStudent> getAllInterviewStudents() {
        return interviewStudentService.getAllInterviewStudents();
    }



}