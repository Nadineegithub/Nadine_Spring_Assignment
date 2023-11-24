package com.example.student_mis.Service.interfaces;

import com.example.student_mis.model.Teacher;
import com.example.student_mis.model.Teacher;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    List <Teacher> getAllTeachers();
    void saveTeacher(Teacher employee);
    Teacher getTeacherById(UUID id);
    void deleteTeacherById(UUID id);

}
