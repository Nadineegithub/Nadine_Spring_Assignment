package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.StudentService;
import com.example.student_mis.model.Student;
import com.example.student_mis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository employeeRepository;

    @Override
    public List<Student> getAllStudents() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveStudent(Student employee) {
        this.employeeRepository.save(employee);

    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = employeeRepository.findById(id);
        Student employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Student not found for id" + id);
        }
        return employee;
    }

    @Override
    public void deleteStudentById(Long id) {
        this.employeeRepository.deleteById(id);

    }


}