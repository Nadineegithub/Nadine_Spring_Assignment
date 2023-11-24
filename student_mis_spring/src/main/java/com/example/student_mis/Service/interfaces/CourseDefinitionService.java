package com.example.student_mis.Service.interfaces;

import com.example.student_mis.model.CourseDefinition;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CourseDefinitionService {
    List <CourseDefinition> getAllCourseDefinitions();
    void saveCourseDefinition(CourseDefinition employee);
    CourseDefinition getCourseDefinitionById(UUID id);
    void deleteCourseDefinitionById(UUID id);

}
