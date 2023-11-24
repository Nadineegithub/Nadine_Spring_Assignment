package com.example.student_mis.controller;

import com.example.student_mis.Service.interfaces.StudentService;
import com.example.student_mis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/student")
    public String viewHome(Model model) {
        List<Student> listStudent = service.getAllStudents();
        model.addAttribute("listStudent", listStudent);
        return "student";
    }
    @GetMapping("/showNewStudentForm")
    public String showNewStudentUnitForm(Model model) {
        Student employee = new Student();
        model.addAttribute("employee", employee);
        return"new_student";

    }
    @PostMapping("/saveStudent")
    public String saveStudentUnit(@ModelAttribute("employee") Student employee) {
        service.saveStudent(employee);
        return "redirect:/student";
    }
    @GetMapping("/showFormForUpdateStd/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Student employee = service.getStudentById(id);
        model.addAttribute(employee);
        return "update_student";
    }
    @GetMapping("/deleteStd/{id}")
    public String deleteStudentUnit(@PathVariable (value="id") Long id) {
        this.service.deleteStudentById(id);
        return "redirect:/student";
    }

}

