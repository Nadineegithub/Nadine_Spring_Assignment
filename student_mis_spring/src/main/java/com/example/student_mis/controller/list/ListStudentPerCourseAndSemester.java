package com.example.student_mis.controller.list;

import com.example.student_mis.Service.interfaces.*;
import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ListStudentPerCourseAndSemester {
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
    private StudentCourseService studentRegistrationService;




    @GetMapping("/listStdPerCourseAndSem")
    public String list(Model model){

        List<StudentCourse> studentRegistrations = studentRegistrationService.getAllStudentCourses();
        List<Semester> semesterList = semesterService.getAllSemesters();
        List<CourseDefinition> courseDefinitionList = courseDefinitionService.getAllCourseDefinitions();

        model.addAttribute("studentRegistrations", studentRegistrations);
        model.addAttribute("semesterList", semesterList);
        model.addAttribute("listOfDepartment", courseDefinitionList);

        return "stdPerCourseAndSem";
    }

    @GetMapping    ("/stdPerCourseAndSem")
    public String stdPerSem(@RequestParam(value = "id") UUID id,@RequestParam(value = "depId") UUID depId, Model model){
        Semester semester = semesterService.getSemesterById(id);
        AcademicUnit academicUnit = academicService.getAcademicUnitById(depId);

       List <StudentCourse> studentRegistration = studentRegistrationService.courseByDepAndSem(depId,id);
       List<Semester> semesterList = semesterService.getAllSemesters();
        List<CourseDefinition> courseDefinitionList = courseDefinitionService.getAllCourseDefinitions();

        model.addAttribute("stdPerSem", studentRegistration);
        model.addAttribute("semesterList", semesterList);
        model.addAttribute("semester", semester);
        model.addAttribute("listOfDepartment", courseDefinitionList);
        return "stdPerCourseAndSem";
    }


}

