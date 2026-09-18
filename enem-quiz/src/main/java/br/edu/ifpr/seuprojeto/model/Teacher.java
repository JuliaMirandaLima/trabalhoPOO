package br.edu.ifpr.seuprojeto.model;

import jakarta.persistence.*;

@Entity
public class Teacher extends Person {

    private String specialty;

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
