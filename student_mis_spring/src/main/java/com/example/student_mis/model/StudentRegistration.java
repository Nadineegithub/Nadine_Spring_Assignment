package com.example.student_mis.model;

import com.example.student_mis.enums.ERegistrationStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
//    Academic Unit
    @OneToOne
    private Student student;
    @Column(name = "registration_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @Generated(GenerationTime.INSERT)
    private LocalDate registrationDate;
    @Enumerated(EnumType.STRING)
    private ERegistrationStatus registrationStatus ;
    @ManyToOne
    private Semester semester;
    public StudentRegistration() {
    }
    @ManyToOne
    private AcademicUnit department;


    public StudentRegistration(UUID id, Student student, LocalDate registrationDate, ERegistrationStatus registrationStatus, Semester semester, AcademicUnit department) {
        this.id = id;
        this.student = student;
        this.registrationDate = registrationDate;
        this.registrationStatus = registrationStatus;
        this.semester = semester;
        this.department = department;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ERegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(ERegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }


    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AcademicUnit getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnit department) {
        this.department = department;
    }
    @PrePersist
    @PreUpdate
    public void setDefaultValues() {
        if (registrationStatus == null) {
            registrationStatus = ERegistrationStatus.PENDING;
        }
    }
}
