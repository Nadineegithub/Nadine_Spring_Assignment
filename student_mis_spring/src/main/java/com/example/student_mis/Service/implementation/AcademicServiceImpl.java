package com.example.student_mis.Service.implementation;

import com.example.student_mis.Service.interfaces.AcademicService;
import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.AcademicUnit;
import com.example.student_mis.repository.AcademicUnitRepository;
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
public class AcademicServiceImpl  extends RemoteException implements AcademicService {
    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    @Override
    public List<AcademicUnit> getAllAcademicUnits() {
        return academicUnitRepository.findAll();
    }

    @Override
    public void saveAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnitRepository.save(academicUnit);

    }

    @Override
    public AcademicUnit getAcademicUnitById(UUID id) {
        Optional<AcademicUnit> optional = academicUnitRepository.findById(id);
        AcademicUnit academicUnit = null;
        if (optional.isPresent()) {
            academicUnit = optional.get();
        } else {
            throw new RuntimeException("AcademicUnit not found for id" + id);
        }
        return academicUnit;
    }

    @Override
    public void deleteAcademicUnitById(UUID id) {
        this.academicUnitRepository.deleteById(id);

    }

    @Override
    public List<AcademicUnit> getAcademicUnitByName(EAcademicUnit name) {
        return academicUnitRepository.findAcademicUnitByName(name);
    }



}
