package com.example.student_command.controller;

import com.example.student_command.entity.*;
import com.example.student_command.service.StudentService;
import com.example.student_command.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author xiaobao
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/teacher/login")
    public String teacherLogin(@RequestParam("userName")String userName,
                       @RequestParam("password")String password,
                       HttpSession session){
        String finalMd5pwd = DigestUtils.md5DigestAsHex(("bwj"+password).getBytes());
        Teacher teacher=teacherService.getTeacherLogin(Integer.parseInt(userName),finalMd5pwd);
        if(teacher!=null){

            session.setAttribute("loginUser",teacher);
            return "redirect:/teacher/main";
        }else{
            log.info("密码错误！");
            return "redirect:/login";
        }
    }

    @PostMapping("/student/login")
    public String studentLogin(@RequestParam("userName")String userName,
                        @RequestParam("password")String password,
                        HttpSession session){
        String finalMd5pwd = DigestUtils.md5DigestAsHex(("bwj"+password).getBytes());
        Student student=studentService.getStudentLogin(Integer.parseInt(userName),finalMd5pwd);
        if(student!=null){
            session.setAttribute("loginStudent",student);
            return "redirect:/student/person";
        }else{
            log.info("密码错误！");
            return "redirect:/login";
        }
    }

}
