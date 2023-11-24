package com.example.student_mis.controller.list;

import com.example.student_mis.Service.interfaces.*;
import com.example.student_mis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ListStudentPerSemester {
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
    @Autowired
    private StudentRegistrationService studentRegistrationService;




    @GetMapping("/listStdPerSem")
    public String list(Model model){

        List<StudentRegistration> studentRegistrations = studentRegistrationService.getAllStudentRegistrations();
        List<Semester> semesterList = semesterService.getAllSemesters();

        model.addAttribute("studentRegistrations", studentRegistrations);
        model.addAttribute("semesterList", semesterList);
        return "stdPerSem";
    }

    @GetMapping    ("/stdPerSem")
    public String stdPerSem(@RequestParam(value = "id") UUID id, Model model){
        Semester semester = semesterService.getSemesterById(id);
       List <StudentRegistration> studentRegistration = studentRegistrationService.listOfStudentsPerSem(id);
       List<Semester> semesterList = semesterService.getAllSemesters();

        model.addAttribute("stdPerSem", studentRegistration);
        model.addAttribute("semesterList", semesterList);
        model.addAttribute("semester", semester);
        return "stdPerSem";
    }


}

