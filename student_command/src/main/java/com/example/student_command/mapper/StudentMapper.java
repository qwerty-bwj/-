package com.example.student_command.mapper;

import com.example.student_command.entity.Course;
import com.example.student_command.entity.Record;
import com.example.student_command.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaobao
 */
@Repository
public interface StudentMapper {

    /**
     * 判断学生登录信息
     * @param sId 学生id
     * @param sPassword 学生密码
     * @return 返回学生信息
     */
    @Select("select * from student where s_id=#{sId} and s_password=#{sPassword}")
    public Student getStudentLogin(@Param("sId") int sId, @Param("sPassword") String sPassword);

    /**
     * 获取学生班级信息
     * @param cId 班级id
     * @return 返回学生班级信息
     */
    @Select("select * from course where c_id=#{cId}")
    public Course getCourseById(int cId);

    /**
     * 获取教师对学生的评价记录
     * @param sId 学生id
     * @param start 页数
     * @return 返回学生评价记录
     */
    public List<Record> getRecordById(@Param("sId") int sId,@Param("start") int start);

    /**
     * 获取学生评价记录总数
     * @param sId 学生id
     * @return 返回学生评价记录总数
     */
    @Select("select count(*) from record where s_id=#{sId}")
    public int getRecordTotal(int sId);

}
