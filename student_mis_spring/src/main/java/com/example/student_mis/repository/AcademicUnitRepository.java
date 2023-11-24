package com.example.student_mis.repository;

import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.AcademicUnit;
import com.example.student_mis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AcademicUnitRepository extends JpaRepository<AcademicUnit, UUID> {
    @Query("select a from AcademicUnit a where a.unit= :name")
    List<AcademicUnit> findAcademicUnitByName(
        @Param("name") EAcademicUnit name);
}
