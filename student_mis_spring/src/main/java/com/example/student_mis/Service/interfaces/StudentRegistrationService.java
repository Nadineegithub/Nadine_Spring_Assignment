package com.example.student_mis.Service.interfaces;

import com.example.student_mis.model.Semester;
import com.example.student_mis.model.StudentRegistration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface StudentRegistrationService {
    List <StudentRegistration> getAllStudentRegistrations();
    void saveStudentRegistration(StudentRegistration employee);
    StudentRegistration getStudentRegistrationById(UUID id);
    void deleteStudentRegistrationById(UUID id);
    List<StudentRegistration> listOfStudentsPerSem(UUID sem);
    List<StudentRegistration> listOfStudentsPerDepAndSem(UUID dep, UUID sem);
    List<StudentRegistration> listStdPerSemOg(String sem);

}
