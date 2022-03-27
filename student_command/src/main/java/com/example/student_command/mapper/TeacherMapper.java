package com.example.student_command.mapper;


import com.example.student_command.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xiaobao
 */
@Repository
public interface TeacherMapper {

    /**
     * 判断教师登录信息
     * @param tId 教师登录ID
     * @param tPassword 教师登录密码
     * @return 返回教师信息
     */
    @Select("select * from teacher where t_id=#{tId} and t_password=#{tPassword}")
    public Teacher getTeacherLogin(@Param("tId") int tId, @Param("tPassword") String tPassword);

    /**
     * 获取教师任教班级课程列表
     * @param tId 教师ID
     * @return 返回课程列表
     */
    public List<Course> getCourseBytId(int tId);

    /**
     * 分页获取该课程的学生名单
     * @param page 存储课程id和页数
     * @return 返回该课程中对映页的学生名单
     */
    @Select("select s_id,s_name from student where c_id=#{cId} limit #{start},10")
    public List<Student> getstudentbycId(Map<String,Integer> page);

    /**
     * 获取该课程学生总数
     * @param cId 课程id
     * @return 返回该课程学生总数
     */
    @Select("select count(*) from student where c_id=#{cId}")
    public int getstudentcountbycid(int cId);

    /**
     * 分页获取评价模板
     * @param start 页数
     * @return 返回该页对映的评价模板
     */
    @Select("select * from template limit #{start},10")
    public List<Template> getTemplate(int start);

    /**
     * 获取评价模板的总数
     * @return 返回评价模板总数
     */
    @Select("select count(*) from template")
    public int getTemplatecount();

    /**
     * 插入评价记录
     * @param sId 学生id
     * @param tId 教师id
     * @param tNum 评价模板id
     * @return 返回0或1表示失败或成功
     */
    @Insert("insert record(s_id,t_id,t_num,time) values(#{sId},#{tId},#{tNum},NOW())")
    public int insertRecord(@Param("sId") int sId,@Param("tId") int tId,@Param("tNum") int tNum);

    /**
     * 更新指定学生成绩
     * @param sId 学生id
     * @param tNum 评价模板id
     * @return 返回0或1
     */
    public int updateStuScore(@Param("sId") int sId,@Param("tNum") int tNum);

    /**
     * 获取该教师的评价记录
     * @param tId 教师id
     * @param start 页数
     * @return 返回该页教师评价记录
     */
    public List<Record> getRecordBytId(@Param("tId") int tId,@Param("start") int start);

    /**
     * 获取该教师的评价记录总数
     * @param tId 教师id
     * @return 返回该教师的评价记录总数
     */
    @Select("select count(*) from record where t_id=#{tId}")
    public int getRecordTotalBytId(int tId);

    /**
     * 撤销评价记录
     * @param rNum 评价记录id
     * @return 返回0或1
     */
    @Delete("delete from record where r_num=#{rNum}")
    public int deleteRecord(int rNum);

    /**
     * 撤销之前给学生加的分
     * @param rNum 评价记录id
     * @return 返回0或1
     */
    public int deleteStuScore(int rNum);
}
