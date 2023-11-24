package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.StudentCourseService;
import com.example.student_mis.model.StudentCourse;
import com.example.student_mis.model.StudentRegistration;
import com.example.student_mis.repository.StudentCourseRepository;
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
public class StudentCourseServiceImpl extends RemoteException implements StudentCourseService {
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

    @Override
    public void saveStudentCourse(StudentCourse academicUnit) {
        this.studentCourseRepository.save(academicUnit);

    }

    @Override
    public StudentCourse getStudentCourseById(UUID id) {
        Optional<StudentCourse> optional = studentCourseRepository.findById(id);
        StudentCourse academicUnit = null;
        if (optional.isPresent()) {
            academicUnit = optional.get();
        } else {
            throw new RuntimeException("StudentCourse not found for id" + id);
        }
        return academicUnit;
    }

    @Override
    public void deleteStudentCourseById(UUID id) {
        this.studentCourseRepository.deleteById(id);

    }

    @Override
    public List<StudentCourse> coursePerStudent(Long regNo) {
        return studentCourseRepository.findCourseByStudent(regNo);
    }

    @Override
    public List<StudentCourse> courseByDepAndSem(UUID courseId, UUID semId) {
        return studentCourseRepository.findStudentsBySemesterAndDepartment(courseId,Optional.of(semId));
    }



}
