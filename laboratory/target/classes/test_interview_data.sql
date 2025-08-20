-- 插入测试面试结果数据
USE laboratory;

-- 确保学生表有数据
INSERT IGNORE INTO student (id, password, name, major, student_id, phone, email, grade) VALUES
(1, '123456', '张三', '计算机科学与技术', '2024001', '13800138001', 'zhangsan@example.com', '2024'),
(2, '123456', '李四', '软件工程', '2024002', '13800138002', 'lisi@example.com', '2024'),
(3, '123456', '王五', '人工智能', '2024003', '13800138003', 'wangwu@example.com', '2024'),
(4, '123456', '赵六', '数据科学', '2024004', '13800138004', 'zhaoliu@example.com', '2024');

-- 清空并重新插入面试结果数据
DELETE FROM interview_result;
INSERT INTO interview_result (student_id, interview_status) VALUES
(1, '通过'),
(2, '通过'),
(3, '待定'),
(4, '未通过');

-- 验证数据
SELECT ir.id, ir.student_id, s.name as student_name, ir.interview_status,
       s.student_id as studentNumber, s.major, s.phone, s.email, s.grade
FROM interview_result ir
LEFT JOIN student s ON ir.student_id = s.id;