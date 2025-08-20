package com.example.laboratory.service;

import com.example.laboratory.entity.Student;

import java.util.List;

public interface StudentService {
    // 添加学生
    int addStudent(Student student);

    // 删除学生
    int deleteStudent(Long id);

    // 更新学生
    int updateStudent(Student student);

    // 根据ID查询学生
    Student getStudentById(Long id);

    // 查询所有学生
    List<Student> getAllStudents();

    // 根据姓名模糊查询学生
    List<Student> getStudentsByName(String name);

    // 根据学号查询学生
    Student getStudentByStudentId(String studentId);

    // 学生登录
    Student login(String studentId, String password);

    // 修改密码
    int changePassword(Long id, String oldPassword, String newPassword);
}