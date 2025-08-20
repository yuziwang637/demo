package com.example.laboratory.mapper;

import com.example.laboratory.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    // 添加学生
    @Insert("INSERT INTO student(password, name, major, student_id, phone, email) VALUES(#{password}, #{name}, #{major}, #{studentId}, #{phone}, #{email})")
    int insert(Student student);

    // 删除学生
    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteById(Long id);

    // 动态更新学生（只更新非空字段）
    @UpdateProvider(type = StudentSqlProvider.class, method = "updateStudent")
    int update(Student student);

    // 根据ID查询学生
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student selectById(Long id);

    // 查询所有学生
    @Select("SELECT * FROM student")
    List<Student> selectAll();

    // 根据姓名模糊查询学生
    @Select("SELECT * FROM student WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Student> selectByName(String name);

    // 根据学号查询学生
    @Select("SELECT * FROM student WHERE student_id = #{studentId}")
    Student selectByStudentId(String studentId);

    // SQL提供者类，用于构建动态SQL
    class StudentSqlProvider {
        public String updateStudent(Student student) {
            return new SQL() {{
                UPDATE("student");
                if (student.getPassword() != null && !student.getPassword().trim().isEmpty()) {
                    SET("password = #{password}");
                }
                if (student.getName() != null && !student.getName().trim().isEmpty()) {
                    SET("name = #{name}");
                }
                if (student.getMajor() != null && !student.getMajor().trim().isEmpty()) {
                    SET("major = #{major}");
                }
                if (student.getStudentId() != null && !student.getStudentId().trim().isEmpty()) {
                    SET("student_id = #{studentId}");
                }
                if (student.getPhone() != null && !student.getPhone().trim().isEmpty()) {
                    SET("phone = #{phone}");
                }
                if (student.getEmail() != null && !student.getEmail().trim().isEmpty()) {
                    SET("email = #{email}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
    }
}