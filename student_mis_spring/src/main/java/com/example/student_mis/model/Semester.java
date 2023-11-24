package com.example.student_mis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String sName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Semester() {
    }

    public Semester(UUID id, String sName, LocalDate startDate, LocalDate endDate) {
        Id = id;
        this.sName = sName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
