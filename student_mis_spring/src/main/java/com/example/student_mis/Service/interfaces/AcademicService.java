package com.example.student_mis.Service.interfaces;

import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.AcademicUnit;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface AcademicService {
    List <AcademicUnit> getAllAcademicUnits();
    void saveAcademicUnit(AcademicUnit employee);
    AcademicUnit getAcademicUnitById(UUID id);
    void deleteAcademicUnitById(UUID id);
    List <AcademicUnit> getAcademicUnitByName(EAcademicUnit name);

}
