package com.example.laboratory.mapper;

import com.example.laboratory.dto.InterviewResultDTO;
import com.example.laboratory.entity.InterviewResult;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface InterviewResultMapper {
    // 添加面试结果
    @Insert("INSERT INTO interview_result(student_id, student_name, interview_status) VALUES(#{studentId}, #{studentName}, #{interviewStatus})")
    int insert(InterviewResult interviewResult);

    // 删除面试结果
    @Delete("DELETE FROM interview_result WHERE id = #{id}")
    int deleteById(Long id);

    // 动态更新面试结果（只更新非空字段）
    @UpdateProvider(type = InterviewResultSqlProvider.class, method = "updateInterviewResult")
    int update(InterviewResult interviewResult);

    // 根据ID查询面试结果
    @Select("SELECT * FROM interview_result WHERE id = #{id}")
    InterviewResult selectById(Long id);

    // 查询所有面试结果
    @Select("SELECT * FROM interview_result")
    List<InterviewResult> selectAll();

    // 根据学生ID查询面试结果
    @Select("SELECT * FROM interview_result WHERE student_id = #{studentId}")
    List<InterviewResult> selectByStudentId(Long studentId);

    // 根据面试状态查询面试结果
    @Select("SELECT * FROM interview_result WHERE interview_status = #{status}")
    List<InterviewResult> selectByStatus(String status);

    // 连表查询所有面试结果及学生详细信息
    @Select("SELECT ir.id, ir.student_id as studentId, COALESCE(s.name, ir.student_name) as studentName, ir.interview_status as interviewStatus, " +
            "COALESCE(s.student_id, '未知学号') as studentNumber, COALESCE(s.major, '未知专业') as major, " +
            "COALESCE(s.phone, '未知电话') as phone, COALESCE(s.email, '未知邮箱') as email " +
            "FROM interview_result ir " +
            "LEFT JOIN student s ON ir.student_id = s.id")
    List<InterviewResultDTO> selectAllWithStudentInfo();

    // 连表查询根据学生ID查询面试结果及学生详细信息
    @Select("SELECT ir.id, ir.student_id as studentId, COALESCE(s.name, ir.student_name) as studentName, ir.interview_status as interviewStatus, " +
            "COALESCE(s.student_id, '未知学号') as studentNumber, COALESCE(s.major, '未知专业') as major, " +
            "COALESCE(s.phone, '未知电话') as phone, COALESCE(s.email, '未知邮箱') as email " +
            "FROM interview_result ir " +
            "LEFT JOIN student s ON ir.student_id = s.id " +
            "WHERE ir.student_id = #{studentId}")
    List<InterviewResultDTO> selectByStudentIdWithStudentInfo(Long studentId);

    // 连表查询根据面试状态查询面试结果及学生详细信息
    @Select("SELECT ir.id, ir.student_id as studentId, COALESCE(s.name, ir.student_name) as studentName, ir.interview_status as interviewStatus, " +
            "COALESCE(s.student_id, '未知学号') as studentNumber, COALESCE(s.major, '未知专业') as major, " +
            "COALESCE(s.phone, '未知电话') as phone, COALESCE(s.email, '未知邮箱') as email " +
            "FROM interview_result ir " +
            "LEFT JOIN student s ON ir.student_id = s.id " +
            "WHERE ir.interview_status = #{status}")
    List<InterviewResultDTO> selectByStatusWithStudentInfo(String status);

    // 连表查询根据ID查询面试结果及学生详细信息
    @Select("SELECT ir.id, ir.student_id as studentId, COALESCE(s.name, ir.student_name) as studentName, ir.interview_status as interviewStatus, " +
            "COALESCE(s.student_id, '未知学号') as studentNumber, COALESCE(s.major, '未知专业') as major, " +
            "COALESCE(s.phone, '未知电话') as phone, COALESCE(s.email, '未知邮箱') as email " +
            "FROM interview_result ir " +
            "LEFT JOIN student s ON ir.student_id = s.id " +
            "WHERE ir.id = #{id}")
    InterviewResultDTO selectByIdWithStudentInfo(Long id);

    // SQL提供者类，用于构建动态SQL
    class InterviewResultSqlProvider {
        public String updateInterviewResult(InterviewResult interviewResult) {
            return new SQL() {{
                UPDATE("interview_result");
                if (interviewResult.getStudentId() != null) {
                    SET("student_id = #{studentId}");
                }
                if (interviewResult.getStudentName() != null && !interviewResult.getStudentName().trim().isEmpty()) {
                    SET("student_name = #{studentName}");
                }
                if (interviewResult.getInterviewStatus() != null && !interviewResult.getInterviewStatus().trim().isEmpty()) {
                    SET("interview_status = #{interviewStatus}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
    }
}