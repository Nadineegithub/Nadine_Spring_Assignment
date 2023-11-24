package com.example.student_mis.Service.interfaces;

import com.example.student_mis.model.StudentCourse;
import com.example.student_mis.model.StudentRegistration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface StudentCourseService {
    List <StudentCourse> getAllStudentCourses();
    void saveStudentCourse(StudentCourse employee);
    StudentCourse getStudentCourseById(UUID id);
    void deleteStudentCourseById(UUID id);
    List<StudentCourse> coursePerStudent(Long regNo);
    List<StudentCourse> courseByDepAndSem(UUID courseId, UUID semId);

}
