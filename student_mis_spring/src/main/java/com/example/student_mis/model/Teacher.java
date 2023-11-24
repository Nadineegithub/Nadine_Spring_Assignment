package com.example.student_mis.model;

import com.example.student_mis.enums.EQualification;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String code;
    private String tName;
    @Enumerated(EnumType.STRING)
    private EQualification qualification;

    private String type;

    public Teacher() {
    }

    public Teacher(UUID id, String code, String tName, EQualification qualification, String type) {
        Id = id;
        this.code = code;
        this.tName = tName;
        this.qualification = qualification;
        this.type = type;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public EQualification getQualification() {
        return qualification;
    }

    public void setQualification(EQualification qualification) {
        this.qualification = qualification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
