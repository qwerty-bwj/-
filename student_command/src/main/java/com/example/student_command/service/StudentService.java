package com.example.student_command.service;

import com.example.student_command.entity.Course;
import com.example.student_command.entity.Pager;
import com.example.student_command.entity.Record;
import com.example.student_command.entity.Student;

/**
 * @author xiaobao
 */
public interface StudentService {

    /**
     * 判断学生登录信息
     * @param sId 学生id
     * @param sPassword 学生密码
     * @return 返回学生信息
     */
    public Student getStudentLogin(int sId, String sPassword);

    /**
     * 获取学生班级信息
     * @param cId 班级id
     * @return 返回学生班级信息
     */
    public Course getCourseById(int cId);

    /**
     * 获取教师对学生的评价记录
     * @param sId 学生id
     * @param start 页数
     * @return 返回学生评价记录
     */
    public Pager<Record> getRecordById(int sId, int start);
}
