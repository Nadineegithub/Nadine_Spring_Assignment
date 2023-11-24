package com.example.student_mis.Service.interfaces;

import com.example.student_mis.model.Semester;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SemesterService {
    List <Semester> getAllSemesters();
    void saveSemester(Semester employee);
    Semester getSemesterById(UUID id);
    void deleteSemesterById(UUID id);

}
