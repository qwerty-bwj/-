package com.example.student_command.controller;

import com.example.student_command.entity.*;
import com.example.student_command.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiaobao
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/main")
    public String tMain(HttpSession session, Model model){
        Teacher teacher=(Teacher) session.getAttribute("loginUser");
        List<Course> courseList=teacherService.getCourseBytId(teacher.getTId());
        model.addAttribute("Courses",courseList);
        return "teacher/course";
    }


    @GetMapping("/teacher/Course/{cId}")
    public String tCourse(@PathVariable("cId")int cId,
                          @RequestParam(value="spn",defaultValue = "1")int spn,
                          @RequestParam(value="tpn",defaultValue = "1")int tpn,
                          Model model){
        Pager<Student> studentLst=teacherService.getStudentBycId(cId,spn);
        model.addAttribute("students",studentLst);
        model.addAttribute("stuPage",spn);
        model.addAttribute("cId",cId);

        Pager<Template> templateLst=teacherService.getTemplate(tpn);
        model.addAttribute("temples",templateLst);
        model.addAttribute("temPage",tpn);
        return "teacher/command";
    }

    @PostMapping("/teacher/commandTmp/{cId}")
    public String commandTmp(@RequestParam("stu")int[] stuId,
                             @RequestParam("tem")int[] temId,
                             @PathVariable("cId")int cId,
                             HttpSession session){
        Teacher teacher=(Teacher) session.getAttribute("loginUser");
        int tId=teacher.getTId();
        for(int stu:stuId){
            for(int tem:temId){
                teacherService.insertRecord(stu,tId,tem);
            }
        }
        return "redirect:/teacher/Course/{cId}";
    }

    @GetMapping("/teacher/record")
    public String getRecord(HttpSession session,
                            Model model,
                            @RequestParam(value = "page",defaultValue = "1") int page){
        Teacher teacher=(Teacher)session.getAttribute("loginUser");
        int tId=teacher.getTId();
        Pager<Record> recordPager=teacherService.getRecord(tId,page);
        model.addAttribute("recordLst",recordPager);
        model.addAttribute("page",page);
        return "teacher/record";
    }

    @GetMapping("/teacher/record/delete")
    public String deleteRecord(@RequestParam("rNum") int rNum){
        teacherService.deleteRecord(rNum);
        return "redirect:/teacher/record";
    }
}
