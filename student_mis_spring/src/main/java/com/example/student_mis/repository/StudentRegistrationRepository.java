package com.example.student_mis.repository;

import com.example.student_mis.enums.EAcademicUnit;
import com.example.student_mis.model.AcademicUnit;
import com.example.student_mis.model.Student;
import com.example.student_mis.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, UUID> {
    @Query("select a from StudentRegistration a where a.semester.Id= :name")
    List<StudentRegistration> findStudentBySemester(
            @Param("name") UUID name);
//    @Query("select a from StudentRegistration a where a.semester.Id= :semester and a.department.Id=: department" )
//    List<StudentRegistration> findStudentBySemesterAndDepartment(
//            @Param("semester") UUID semester,
//            @Param("department") UUID department);
    @Query( "select s from StudentRegistration s where s.semester.sName like %:keyword%")
    List<StudentRegistration> findByKeyword(@Param("keyword") String keyword);
    @Query("SELECT a FROM StudentRegistration a WHERE a.semester.Id = :semesterId AND (:departmentId IS NULL OR a.department.Id = :departmentId)")
    List<StudentRegistration> findStudentBySemesterAndDepartment(@Param("semesterId") UUID semesterId, @Param("departmentId") Optional<UUID> departmentId);
}
