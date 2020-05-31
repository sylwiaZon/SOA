package pl.edu.agh.soa.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Professor {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;

    public Professor() {
    }

    public Professor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
