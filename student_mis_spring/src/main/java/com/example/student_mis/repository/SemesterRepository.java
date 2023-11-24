package com.example.student_mis.repository;

import com.example.student_mis.model.Semester;
import com.example.student_mis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SemesterRepository extends JpaRepository<Semester, UUID> {
}
