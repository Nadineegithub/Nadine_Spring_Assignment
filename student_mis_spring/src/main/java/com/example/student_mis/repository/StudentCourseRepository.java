package com.example.student_mis.repository;

import com.example.student_mis.model.Course;
import com.example.student_mis.model.Student;
import com.example.student_mis.model.StudentCourse;
import com.example.student_mis.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, UUID> {
    @Query("select a from StudentCourse a where a.studentRegistration.student.regNo= :name")
    List<StudentCourse> findCourseByStudent(
            @Param("name") Long name);
    @Query("SELECT a FROM StudentCourse a WHERE a.course.courseDefinition.Id = :courseId AND (:departmentId IS NULL OR a.studentRegistration.department.Id = :departmentId)")
    List<StudentCourse> findStudentsBySemesterAndDepartment(@Param("courseId") UUID courseId, @Param("departmentId") Optional<UUID> departmentId);

}
