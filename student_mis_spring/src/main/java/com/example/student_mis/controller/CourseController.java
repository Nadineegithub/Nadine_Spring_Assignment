package com.example.student_mis.controller;

import com.example.student_mis.Service.interfaces.*;
import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class CourseController {
    @Autowired
    private CourseService service;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private CourseDefinitionService courseDefinitionService;
    @Autowired
    private AcademicService academicService;
    @Autowired
    private CourseService courseService;



    @GetMapping("/course")
    public String viewHome(Model model) {
        List<Course> listCourses = service.getAllCourses();
        model.addAttribute("listCourses", listCourses);
        return "course";
    }
    @GetMapping("/showNewCourseForm")
    public String showNewCourseForm(Model model) {
        Course employee = new Course();
        EAcademicUnit name = EAcademicUnit.DEPARTMENT;

        List<AcademicUnit> listOfPrograms = academicService.getAcademicUnitByName(name);
        List<Semester> semesterList = semesterService.getAllSemesters();
        List<Teacher> teacherList = teacherService.getAllTeachers();
        List<CourseDefinition> courseDefinitionsList = courseDefinitionService.getAllCourseDefinitions();

        model.addAttribute("semesterList", semesterList);
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("courseDefinitionList", courseDefinitionsList);
        model.addAttribute("courseDis", employee);
        model.addAttribute("listOfPrograms", listOfPrograms);
        return "new_course";

    }
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("employee") Course employee) {
        service.saveCourse(employee);
        return "redirect:/course";
    }
    @GetMapping("/showFormForUpdateCourse/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        Course employee = service.getCourseById(id);
        EAcademicUnit name = EAcademicUnit.DEPARTMENT;

        List<Semester> semesterList = semesterService.getAllSemesters();
        List<Teacher> teacherList = teacherService.getAllTeachers();
        List<CourseDefinition> courseDefinitionsList = courseDefinitionService.getAllCourseDefinitions();
        List<AcademicUnit> listOfPrograms = academicService.getAcademicUnitByName(name);

        model.addAttribute("semesterList", semesterList);
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("courseDefinitionList", courseDefinitionsList);
        model.addAttribute("listOfPrograms", listOfPrograms);
        model.addAttribute(employee);
        return "update_course";
    }
    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable (value="id") UUID id) {
        this.service.deleteCourseById(id);
        return "redirect:/course";
    }

}

