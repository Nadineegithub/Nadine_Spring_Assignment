package com.example.student_mis.controller.list;

import com.example.student_mis.Service.interfaces.*;
import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.AcademicUnit;
import com.example.student_mis.model.Course;
import com.example.student_mis.model.Semester;
import com.example.student_mis.model.StudentRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ListCoursePerDepartmentAndSemester {
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





    @GetMapping("/listCoursePerDepAndSem")
    public String list(Model model){

        List<Course> studentRegistrations = courseService.getAllCourses();
        List<Semester> semesterList = semesterService.getAllSemesters();

        EAcademicUnit name = EAcademicUnit.DEPARTMENT;

        List<AcademicUnit> listOfDepartment = academicService.getAcademicUnitByName(name);

        model.addAttribute("studentRegistrations", studentRegistrations);
        model.addAttribute("semesterList", semesterList);
        model.addAttribute("listOfDepartment", listOfDepartment);

        return "coursePerDepAndSem";
    }

    @GetMapping    ("/coursePerDepAndSem")
    public String stdPerSem(@RequestParam(value = "id") UUID id,@RequestParam(value = "depId") UUID depId, Model model){
        Semester semester = semesterService.getSemesterById(id);
       List <Course> studentRegistration = courseService.listOfCoursePerDepAndSem(id, depId);
       List<Semester> semesterList = semesterService.getAllSemesters();

        EAcademicUnit name = EAcademicUnit.DEPARTMENT;

        List<AcademicUnit> listOfDepartment = academicService.getAcademicUnitByName(name);

        model.addAttribute("stdPerSem", studentRegistration);
        model.addAttribute("semesterList", semesterList);
        model.addAttribute("semester", semester);
        model.addAttribute("listOfDepartment", listOfDepartment);
        return "coursePerDepAndSem";
    }


}

