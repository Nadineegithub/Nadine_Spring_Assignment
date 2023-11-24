package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.CourseDefinitionService;
import com.example.student_mis.model.CourseDefinition;
import com.example.student_mis.repository.CourseDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseDefinitionServiceImpl implements CourseDefinitionService {
    @Autowired
    private CourseDefinitionRepository courseDefinitionRepository;

    @Override
    public List<CourseDefinition> getAllCourseDefinitions() {
        return courseDefinitionRepository.findAll();
    }

    @Override
    public void saveCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinitionRepository.save(courseDefinition);

    }

    @Override
    public CourseDefinition getCourseDefinitionById(UUID id) {
        Optional<CourseDefinition> optional = courseDefinitionRepository.findById(id);
        CourseDefinition courseDefinition = null;
        if (optional.isPresent()) {
            courseDefinition = optional.get();
        } else {
            throw new RuntimeException("CourseDefinition not found for id" + id);
        }
        return courseDefinition;
    }

    @Override
    public void deleteCourseDefinitionById(UUID id) {
        this.courseDefinitionRepository.deleteById(id);

    }


}