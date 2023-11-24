package com.example.student_mis.controller;

import com.example.student_mis.Service.interfaces.CourseDefinitionService;
import com.example.student_mis.model.CourseDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class CourseDefinitionController {
    @Autowired
    private CourseDefinitionService service;

    @GetMapping("/CourseDefinition")
    public String viewHome(Model model) {
        List<CourseDefinition> listCourses = service.getAllCourseDefinitions();
        model.addAttribute("listCourses", listCourses);
        return "course_definition";
    }
    @GetMapping("/showNewCourseDefinitionForm")
    public String showNewCourseDefinitionUnitForm(Model model) {
        CourseDefinition employee = new CourseDefinition();
        model.addAttribute("employee", employee);
        return"new_course_definition";

    }
    @PostMapping("/saveCourseDefinition")
    public String saveCourseDefinitionUnit(@ModelAttribute("employee") CourseDefinition employee) {
        service.saveCourseDefinition(employee);
        return "redirect:/CourseDefinition";
    }
    @GetMapping("/showFormForUpdateCourseDefinition/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        CourseDefinition employee = service.getCourseDefinitionById(id);
        model.addAttribute(employee);
        return "update_course_definition";
    }
    @GetMapping("/deleteCourseDefinition/{id}")
    public String deleteCourseDefinitionUnit(@PathVariable (value="id") UUID id) {
        this.service.deleteCourseDefinitionById(id);
        return "redirect:/CourseDefinition";
    }

}

