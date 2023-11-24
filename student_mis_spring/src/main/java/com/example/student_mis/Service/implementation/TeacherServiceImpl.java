package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.AcademicService;
import com.example.student_mis.Service.interfaces.TeacherService;
import com.example.student_mis.model.Teacher;
import com.example.student_mis.repository.TeacherRepository;
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
public class TeacherServiceImpl extends RemoteException implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher academicUnit) {
        this.teacherRepository.save(academicUnit);

    }

    @Override
    public Teacher getTeacherById(UUID id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        Teacher academicUnit = null;
        if (optional.isPresent()) {
            academicUnit = optional.get();
        } else {
            throw new RuntimeException("Teacher not found for id" + id);
        }
        return academicUnit;
    }

    @Override
    public void deleteTeacherById(UUID id) {
        this.teacherRepository.deleteById(id);

    }


}
