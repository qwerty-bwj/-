package com.example.student_command.service.impl;

import com.example.student_command.entity.*;
import com.example.student_command.mapper.TeacherMapper;
import com.example.student_command.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaobao
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherLogin(int tId, String tPassword){
        return teacherMapper.getTeacherLogin(tId,tPassword);
    }

    @Override
    public List<Course> getCourseBytId(int tId) {
        return teacherMapper.getCourseBytId(tId);
    }

    @Override
    public Pager<Student> getStudentBycId(int cId, int pn) {
        Map<String, Integer> page = new HashMap<String, Integer>();
        page.put("start",(pn-1)*10);
        page.put("cId",cId);
        List<Student> sLst=teacherMapper.getstudentbycId(page);
        Pager<Student> pager = new Pager<Student>();
        pager.setRows(sLst);
        pager.setTotal(teacherMapper.getstudentcountbycid(cId));
        return pager;
    }

    @Override
    public Pager<Template> getTemplate(int pn) {
        Pager<Template> pager=new Pager<Template>();
        pager.setRows(teacherMapper.getTemplate((pn-1)*10));
        pager.setTotal(teacherMapper.getTemplatecount());
        return pager;
    }

    @Override
    public void insertRecord(int sId, int tId, int tNum) {
        int jub0=0;
        while(jub0==0){
            jub0=teacherMapper.insertRecord(sId,tId,tNum);
        }
        int jub1=0;
        while(jub1==0){
            jub1=teacherMapper.updateStuScore(sId,tNum);
        }
    }

    @Override
    public Pager<Record> getRecord(int tId,int pn) {
        Pager<Record> pager=new Pager<Record>();
        pager.setRows(teacherMapper.getRecordBytId(tId,(pn-1)*10));
        pager.setTotal(teacherMapper.getRecordTotalBytId(tId));
        return pager;
    }

    @Override
    public void deleteRecord(int rNum) {
        int jub0=0;
        while(jub0==0){
            jub0=teacherMapper.deleteStuScore(rNum);
        }
        int jub1=0;
        while(jub1==0){
            jub1=teacherMapper.deleteRecord(rNum);
        }
    }

}
