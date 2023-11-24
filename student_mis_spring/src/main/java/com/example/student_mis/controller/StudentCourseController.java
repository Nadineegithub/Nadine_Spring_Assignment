package com.example.student_mis.controller;

import com.example.student_mis.Service.interfaces.*;
import com.example.student_mis.Service.interfaces.StudentCourseService;
import com.example.student_mis.model.*;
import com.example.student_mis.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentCourseController {
    @Autowired
    private StudentCourseService service;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentRegistrationService studentRegistrationService;



    @GetMapping("/StudentCourse")
    public String viewHome(Model model) {
        List<StudentCourse> listStudentCourses = service.getAllStudentCourses();
        model.addAttribute("list", listStudentCourses);
        return "student_course";
    }
//	 }
    @GetMapping("/showNewStudentCourseForm")
    public String showNewStudentCourseForm(Model model) {
        StudentCourse employee = new StudentCourse();
        List<StudentRegistration> studentRegistrationsList = studentRegistrationService.getAllStudentRegistrations();
        List<Course> coursesList = courseService.getAllCourses();
        List<StudentCourse> courseDefinitionsList = service.getAllStudentCourses();

        model.addAttribute("studentRegistration", studentRegistrationsList);
        model.addAttribute("courseList", coursesList);
        model.addAttribute("courseDefinitionList", courseDefinitionsList);
        model.addAttribute("stdCourse", employee);
        return "new_student_course";

    }
    @PostMapping("/saveStudentCourse")
    public String saveStudentCourse(@ModelAttribute("employee") StudentCourse employee) {
        service.saveStudentCourse(employee);
        return "redirect:/StudentCourse";
    }
    @GetMapping("/showFormForUpdateStudentCourse/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        StudentCourse employee = service.getStudentCourseById(id);
        List<StudentRegistration> studentRegistrationsList = studentRegistrationService.getAllStudentRegistrations();
        List<Course> coursesList = courseService.getAllCourses();
        List<StudentCourse> studentCoursesList = service.getAllStudentCourses();

        model.addAttribute("studentRegistration", studentRegistrationsList);
        model.addAttribute("courseList", coursesList);
        model.addAttribute("studentCourseLis", studentCoursesList);
        model.addAttribute(employee);
        return "update_student_course";
    }
    @GetMapping("/deleteStudentCourse/{id}")
    public String deleteStudentCourse(@PathVariable (value="id") UUID id) {
        this.service.deleteStudentCourseById(id);
        return "redirect:/StudentCourse";
    }

}

