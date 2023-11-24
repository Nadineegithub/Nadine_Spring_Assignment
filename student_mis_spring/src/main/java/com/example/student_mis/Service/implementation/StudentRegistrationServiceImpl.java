package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.StudentRegistrationService;
import com.example.student_mis.model.StudentRegistration;
import com.example.student_mis.repository.StudentRegistrationRepository;
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
public class StudentRegistrationServiceImpl extends RemoteException implements StudentRegistrationService {
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    @Override
    public List<StudentRegistration> getAllStudentRegistrations() {
        return studentRegistrationRepository.findAll();
    }

    @Override
    public void saveStudentRegistration(StudentRegistration academicUnit) {
        this.studentRegistrationRepository.save(academicUnit);

    }

    @Override
    public StudentRegistration getStudentRegistrationById(UUID id) {
        Optional<StudentRegistration> optional = studentRegistrationRepository.findById(id);
        StudentRegistration academicUnit = null;
        if (optional.isPresent()) {
            academicUnit = optional.get();
        } else {
            throw new RuntimeException("StudentRegistration not found for id" + id);
        }
        return academicUnit;
    }

    @Override
    public void deleteStudentRegistrationById(UUID id) {
        this.studentRegistrationRepository.deleteById(id);

    }

    @Override
    public List<StudentRegistration> listOfStudentsPerSem(UUID sem) {
        return studentRegistrationRepository.findStudentBySemester(sem);
    }

    @Override
    public List<StudentRegistration> listOfStudentsPerDepAndSem(UUID sem, UUID dep) {
        return studentRegistrationRepository.findStudentBySemesterAndDepartment(sem,Optional.of(dep));
    }



    @Override
    public List<StudentRegistration> listStdPerSemOg(String sem) {
        return studentRegistrationRepository.findByKeyword(sem);
    }

}
