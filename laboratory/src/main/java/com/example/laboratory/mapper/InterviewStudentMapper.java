package com.example.laboratory.mapper;

import com.example.laboratory.entity.InterviewStudent;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface InterviewStudentMapper {
    
    @Insert("INSERT INTO interview_student(name, position, date, start_time, end_time, interviewers) VALUES(#{name}, #{position}, #{date}, #{startTime}, #{endTime}, #{interviewers})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(InterviewStudent interviewStudent);

    @Delete("DELETE FROM interview_student WHERE id = #{id}")
    int deleteById(Long id);

    // 动态更新面试学生（只更新非空字段）
    @UpdateProvider(type = InterviewStudentSqlProvider.class, method = "updateInterviewStudent")
    int update(InterviewStudent interviewStudent);

    @Select("SELECT * FROM interview_student WHERE id = #{id}")
    InterviewStudent selectById(Long id);

    @Select("SELECT * FROM interview_student")
    List<InterviewStudent> selectAll();

    @Select("SELECT * FROM interview_student WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<InterviewStudent> selectByName(String name);

    @Select("SELECT * FROM interview_student WHERE date = #{date}")
    List<InterviewStudent> selectByDate(String date);

    // SQL提供者类，用于构建动态SQL
    class InterviewStudentSqlProvider {
        public String updateInterviewStudent(InterviewStudent interviewStudent) {
            return new SQL() {{
                UPDATE("interview_student");
                if (interviewStudent.getName() != null && !interviewStudent.getName().trim().isEmpty()) {
                    SET("name = #{name}");
                }
                if (interviewStudent.getPosition() != null && !interviewStudent.getPosition().trim().isEmpty()) {
                    SET("position = #{position}");
                }
                if (interviewStudent.getDate() != null && !interviewStudent.getDate().trim().isEmpty()) {
                    SET("date = #{date}");
                }
                if (interviewStudent.getStartTime() != null && !interviewStudent.getStartTime().trim().isEmpty()) {
                    SET("start_time = #{startTime}");
                }
                if (interviewStudent.getEndTime() != null && !interviewStudent.getEndTime().trim().isEmpty()) {
                    SET("end_time = #{endTime}");
                }
                if (interviewStudent.getInterviewers() != null && !interviewStudent.getInterviewers().trim().isEmpty()) {
                    SET("interviewers = #{interviewers}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
    }
}