package com.example.student_mis.repository;

import com.example.student_mis.model.Course;
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
public interface CourseRepository extends JpaRepository<Course, UUID> {
    @Query("SELECT a FROM Course a WHERE a.semester.Id = :semesterId AND (:departmentId IS NULL OR a.department.Id = :departmentId)")
    List<Course> findCourseBySemesterAndDepartment(@Param("semesterId") UUID semesterId, @Param("departmentId") Optional<UUID> departmentId);

}
