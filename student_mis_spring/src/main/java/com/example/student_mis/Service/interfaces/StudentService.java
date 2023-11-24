package com.example.student_mis.Service.interfaces;

import com.example.student_mis.model.Student;
import org.springframework.data.domain.Page;

import java.rmi.RemoteException;
import java.util.List;

public interface StudentService {
    List <Student> getAllStudents();
    void saveStudent(Student employee);
    Student getStudentById(Long id);
    void deleteStudentById(Long id);

}
