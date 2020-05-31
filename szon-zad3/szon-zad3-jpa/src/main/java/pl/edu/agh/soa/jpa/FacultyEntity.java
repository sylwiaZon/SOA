package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="faculty")
public class FacultyEntity {
    @Id
    @Column(name="faculty_id")
    @GeneratedValue
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
