package com.example.student_command.service.impl;

import com.example.student_command.entity.Course;
import com.example.student_command.entity.Pager;
import com.example.student_command.entity.Record;
import com.example.student_command.entity.Student;
import com.example.student_command.mapper.StudentMapper;
import com.example.student_command.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author xiaobao
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentLogin(int sId, String sPassword) {
        return studentMapper.getStudentLogin(sId,sPassword);
    }

    @Override
    public Course getCourseById(int cId) {
        return studentMapper.getCourseById(cId);
    }

    @Override
    public Pager<Record> getRecordById(int sId, int pn) {
        Pager<Record> pager=new Pager<Record>();
        pager.setRows(studentMapper.getRecordById(sId,(pn-1)*10));
        pager.setTotal(studentMapper.getRecordTotal(sId));
        return pager;
    }
}
