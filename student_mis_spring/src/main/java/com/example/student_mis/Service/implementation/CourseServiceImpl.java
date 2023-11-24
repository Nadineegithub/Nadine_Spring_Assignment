package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.CourseService;
import com.example.student_mis.model.Course;
import com.example.student_mis.model.StudentRegistration;
import com.example.student_mis.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl extends RemoteException implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course academicUnit) {
        this.courseRepository.save(academicUnit);

    }

    @Override
    public Course getCourseById(UUID id) {
        Optional<Course> optional = courseRepository.findById(id);
        Course academicUnit = null;
        if (optional.isPresent()) {
            academicUnit = optional.get();
        } else {
            throw new RuntimeException("Course not found for id" + id);
        }
        return academicUnit;
    }

    @Override
    public void deleteCourseById(UUID id) {
        this.courseRepository.deleteById(id);

    }


    @Override
    public List<Course> listOfCoursePerDepAndSem(UUID sem, UUID dep) {
        return courseRepository.findCourseBySemesterAndDepartment(sem, Optional.of(dep));
    }


}
