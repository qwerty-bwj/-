package com.example.student_command.service;

import com.example.student_command.entity.*;

import java.util.List;

/**
 * @author xiaobao
 */
public interface TeacherService {

    /**
     * 判断教师登录信息
     * @param tId 教师登录ID
     * @param tPassword 教师登录密码
     * @return 返回教师信息
     */
    public Teacher getTeacherLogin(int tId, String tPassword);

    /**
     * 获取教师任教班级课程列表
     * @param tId 教师ID
     * @return 返回课程列表
     */
    public List<Course> getCourseBytId(int tId);

    /**
     * 分页获取该课程的学生名单
     * @param cId 课程id
     * @param pn 页数
     * @return 该页的学生列表
     */
    public Pager<Student> getStudentBycId(int cId, int pn);

    /**
     * 获取评价模板
     * @param pn 页数
     * @return 返回该页评价模板
     */
    public Pager<Template> getTemplate(int pn);

    /**
     * 插入评价记录
     * @param sId 学生id
     * @param tId 教师id
     * @param tNum 评价模板id
     * @return 返回0或1
     */
    public void insertRecord(int sId,int tId,int tNum);

    /**
     * 获取该教师评价记录
     * @param tId 教师id
     * @param pn 页数
     * @return 返回教师评价记录
     */
    public Pager<Record> getRecord(int tId,int pn);

    /**
     * 撤销评价记录
     * @param rNum 评价记录id
     * @return 返回0或1
     */
    public void deleteRecord(int rNum);
}
