package com.example.student_mis.controller.list;

import com.example.student_mis.Service.interfaces.*;
import com.example.student_mis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ListCoursePerStudent {
    @Autowired
    private CourseDefinitionService courseService;
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private StudentService studentService;




    @GetMapping("/listCoursePerStudent")
    public String list(Model model){

        List<StudentCourse> studentRegistrations = studentCourseService.getAllStudentCourses();
        List<Student> courseList = studentService.getAllStudents();

        model.addAttribute("studentRegistrations", studentRegistrations);
        model.addAttribute("semesterList", courseList);
        return "coursePerStudent";
    }

    @GetMapping("/coursePerStudent")
    public String coursesPerStudent(@RequestParam("regNo") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        List<StudentCourse> studentRegistration = studentCourseService.coursePerStudent(id);
        List<Student> courseList = studentService.getAllStudents();

        model.addAttribute("stdPerSem", studentRegistration);
        model.addAttribute("courseList", student);
        model.addAttribute("semester", courseList);

        return "coursePerStudent";

    }

}

