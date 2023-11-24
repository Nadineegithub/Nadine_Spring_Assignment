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
public class StudentRegistrationController {
    @Autowired
    private StudentRegistrationService service;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private AcademicService academicService;



    @GetMapping("/studentRegistration")
    public String viewHome(Model model) {
        List<StudentRegistration> listStudentRegistrations= service.getAllStudentRegistrations();
        model.addAttribute("listStudentRegistrations", listStudentRegistrations);
        return "studentRegistration";
    }
//	 }
    @GetMapping("/showNewStudentRegistrationForm")
    public String showNewStudentRegistrationForm(Model model) {
        StudentRegistration employee = new StudentRegistration();
        List<Semester> semesterList = semesterService.getAllSemesters();
        List<Student> studentList = studentService.getAllStudents();
        EAcademicUnit name = EAcademicUnit.DEPARTMENT;
        List<AcademicUnit> listOfPrograms = academicService.getAcademicUnitByName(name);
        model.addAttribute("listOfPrograms", listOfPrograms);

        model.addAttribute("semesterList", semesterList);
        model.addAttribute("studentList", studentList);
        model.addAttribute("studentRegistrationDis", employee);
        return "new_studentRegistration";

    }
    @PostMapping("/saveStudentRegistration")
    public String saveStudentRegistration(@ModelAttribute("employee") StudentRegistration employee) {
        service.saveStudentRegistration(employee);
        return "redirect:/studentRegistration";
    }
    @GetMapping("/showFormForUpdateStudentRegistration/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        StudentRegistration employee = service.getStudentRegistrationById(id);
        List<Semester> semesterList = semesterService.getAllSemesters();

        List<Student> studentList = studentService.getAllStudents();
        EAcademicUnit name = EAcademicUnit.DEPARTMENT;
        List<AcademicUnit> listOfPrograms = academicService.getAcademicUnitByName(name);
        
        model.addAttribute("listOfPrograms", listOfPrograms);
        model.addAttribute("semesterList", semesterList);
        model.addAttribute("studentList", studentList);
        model.addAttribute(employee);
        return "update_studentRegistration";
    }
    @GetMapping("/deleteStudentRegistration/{id}")
    public String deleteStudentRegistration(@PathVariable (value="id") UUID id) {
        this.service.deleteStudentRegistrationById(id);
        return "redirect:/studentRegistration";
    }

}

