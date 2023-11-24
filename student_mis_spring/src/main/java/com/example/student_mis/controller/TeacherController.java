package com.example.student_mis.controller;

import com.example.student_mis.Service.interfaces.AcademicService;
import com.example.student_mis.Service.interfaces.TeacherService;
import com.example.student_mis.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService service;

    @GetMapping("/teacher")
    public String viewHome(Model model) {
        List<Teacher> listTeachers = service.getAllTeachers();
			model.addAttribute("listTeachers", listTeachers);
        return "teacher";
    }
    @GetMapping("/showNewTeacherForm")
    public String showNewTeacherForm(Model model) {
        Teacher employee = new Teacher();
        model.addAttribute("employee", employee);
        return "new_teacher";

    }
    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("employee") Teacher employee) {
        service.saveTeacher(employee);
        return "redirect:/teacher";
    }
    @GetMapping("/showFormForUpdateTeacher/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        Teacher employee = service.getTeacherById(id);
        model.addAttribute(employee);
        return "update_teacher";
    }
    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable (value="id") UUID id) {
        this.service.deleteTeacherById(id);
        return "redirect:/teacher";
    }

}

