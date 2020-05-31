package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.ProfessorEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Professor;

public class ProfessorMapper {
    public static Professor mapEntityToProfessor(ProfessorEntity professorEntity) {
        Professor professor = new Professor();
        professor.setName(professorEntity.getName());
        professor.setSurname(professorEntity.getSurname());
        return professor;
    }

    public static ProfessorEntity mapProfessorToEntity(Professor professor) {
        ProfessorEntity professorEntity = new ProfessorEntity();
        professorEntity.setName(professor.getName());
        professorEntity.setSurname(professor.getSurname());
        return professorEntity;
    }
}
