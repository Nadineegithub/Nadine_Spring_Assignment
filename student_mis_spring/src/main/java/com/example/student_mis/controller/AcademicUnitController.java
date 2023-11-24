package com.example.student_mis.controller;

import com.example.student_mis.Service.interfaces.AcademicService;
import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.AcademicUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class AcademicUnitController {
    @Autowired
    private AcademicService service;

    @GetMapping("/academicUnit")
    public String viewHome(Model model) {
        List<AcademicUnit> listAcademicUnits = service.getAllAcademicUnits();
        model.addAttribute("listAcademicUnits", listAcademicUnits);
        return "academic_unit";
    }
    @GetMapping("/showNewProgrammeForm")
    public String showNewAcademicUnitForm(Model model) {
        AcademicUnit employee = new AcademicUnit();
        int min = 10000;
        int max = 99999;
        UUID programId = UUID.randomUUID();
        Random random = new Random();
        int randomCode = random.nextInt(max - min + 1) + min;
        model.addAttribute("randomCode", randomCode);
        model.addAttribute("programId", programId);
        model.addAttribute("employee", employee);

        return "new_programme";

    }
    @GetMapping("/showNewFacultyForm")
    public String showNewFacultyForm(Model model) {
        AcademicUnit employee = new AcademicUnit();
        int min = 10000; // Smallest 5-digit number
        int max = 99999; // Largest 5-digit number

        EAcademicUnit name = EAcademicUnit.PROGRAMME;

        List<AcademicUnit> listOfPrograms = service.getAcademicUnitByName(name);

        Random random = new Random();
        int randomCode = random.nextInt(max - min + 1) + min;
        model.addAttribute("randomCode", randomCode);

        model.addAttribute("listOfPrograms",listOfPrograms);

        model.addAttribute("faculty", employee);
        return "new_faculty";

    }
    @GetMapping("/showNewDepartmentForm")
    public String showNewDepartmentForm(Model model) {
        AcademicUnit employee = new AcademicUnit();
        int min = 10000; // Smallest 5-digit number
        int max = 99999; // Largest 5-digit number

        EAcademicUnit name = EAcademicUnit.FACULTY;

        List<AcademicUnit> listOfPrograms = service.getAcademicUnitByName(name);

        Random random = new Random();
        int randomCode = random.nextInt(max - min + 1) + min;
        model.addAttribute("randomCode", randomCode);

        model.addAttribute("listOfPrograms",listOfPrograms);

        model.addAttribute("department", employee);
        return "new_department";

    }
    @PostMapping("/saveProgramme")
    public String saveAcademicUnit(@ModelAttribute("employee") AcademicUnit employee) {
        service.saveAcademicUnit(employee);
        return "redirect:/academicUnit";
    }


}

