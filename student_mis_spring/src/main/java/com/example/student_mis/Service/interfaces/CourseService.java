package com.example.student_mis.Service.interfaces;

import com.example.student_mis.model.Course;
import com.example.student_mis.model.StudentRegistration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    List <Course> getAllCourses();
    void saveCourse(Course employee);
    Course getCourseById(UUID id);
    void deleteCourseById(UUID id);
    List<Course> listOfCoursePerDepAndSem(UUID dep, UUID sem);

}
