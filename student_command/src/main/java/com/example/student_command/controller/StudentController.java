package com.example.student_command.controller;

import com.example.student_command.entity.Course;
import com.example.student_command.entity.Pager;
import com.example.student_command.entity.Record;
import com.example.student_command.entity.Student;
import com.example.student_command.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author xiaobao
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/person")
    public String person(HttpSession session,
                         Model model,
                         @RequestParam(value = "page",defaultValue = "1")int page){
        Student student=(Student)session.getAttribute("loginStudent");
        Course course=studentService.getCourseById(student.getCId());
        Pager<Record> pager=studentService.getRecordById(student.getSId(),page);
        model.addAttribute("student",student);
        model.addAttribute("course",course);
        model.addAttribute("records",pager);
        model.addAttribute("page",page);
        return "student/person";
    }
}
