package com.example.student_mis.controller;

import com.example.student_mis.Service.interfaces.SemesterService;
import com.example.student_mis.model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class SemesterController {
    @Autowired
    private SemesterService service;

    @GetMapping("/semester")
    public String viewHome(Model model) {
        List<Semester> listSemesters =service.getAllSemesters();
        model.addAttribute("listSemesters", listSemesters);
        return "semester";
    }
    @GetMapping("/showNewSemesterForm")
    public String showNewSemesterForm(Model model) {
        Semester semester = new Semester();
        model.addAttribute("semester", semester);
        return "new_semester";

    }
    @PostMapping("/saveSemester")
    public String saveSemester(@ModelAttribute("semester") Semester semester) {
        service.saveSemester(semester);
        return "redirect:/semester";
    }
    @GetMapping("/showFormForUpdateSemester/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        Semester semester = service.getSemesterById(id);
        model.addAttribute(semester);
        return "update_semester";
    }
    @GetMapping("/deleteSemester/{id}")
    public String deleteSemester(@PathVariable (value="id") UUID id) {
        this.service.deleteSemesterById(id);
        return "redirect:/semester";
    }

}

