package com.example.student_mis.model;
//import jakarta.persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class CourseDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String Code;
    private String cName;
    private String description;

    public CourseDefinition() {
    }

    public CourseDefinition(UUID id, String code, String cName, String description) {
        Id = id;
        Code = code;
        this.cName = cName;
        this.description = description;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
