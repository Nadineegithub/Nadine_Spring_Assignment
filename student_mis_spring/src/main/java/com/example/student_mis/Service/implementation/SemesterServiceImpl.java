package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.SemesterService;
import com.example.student_mis.model.Semester;
import com.example.student_mis.repository.SemesterRepository;
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
public class SemesterServiceImpl extends RemoteException implements SemesterService {
    @Autowired
    private SemesterRepository semesterRepository;

    @Override
    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    @Override
    public void saveSemester(Semester academicUnit) {
        this.semesterRepository.save(academicUnit);

    }

    @Override
    public Semester getSemesterById(UUID id) {
        Optional<Semester> optional = semesterRepository.findById(id);
        Semester academicUnit = null;
        if (optional.isPresent()) {
            academicUnit = optional.get();
        } else {
            throw new RuntimeException("Semester not found for id" + id);
        }
        return academicUnit;
    }

    @Override
    public void deleteSemesterById(UUID id) {
        this.semesterRepository.deleteById(id);

    }


}
