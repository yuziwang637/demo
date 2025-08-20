package com.example.laboratory.service.impl;

import com.example.laboratory.entity.Student;
import com.example.laboratory.mapper.StudentMapper;
import com.example.laboratory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int deleteStudent(Long id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentMapper.selectByName(name);
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        return studentMapper.selectByStudentId(studentId);
    }

    @Override
    public Student login(String studentId, String password) {
        Student student = studentMapper.selectByStudentId(studentId);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    @Override
    public int changePassword(Long id, String oldPassword, String newPassword) {
        Student student = studentMapper.selectById(id);
        if (student == null || !student.getPassword().equals(oldPassword)) {
            return 0;
        }
        student.setPassword(newPassword);
        return studentMapper.update(student);
    }
}