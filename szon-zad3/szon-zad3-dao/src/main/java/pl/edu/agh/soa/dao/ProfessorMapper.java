package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.FacultyEntity;
import pl.edu.agh.soa.jpa.ProfessorEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Faculty;
import pl.edu.agh.soa.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorMapper {
    public static Professor mapEntityToProfessor(ProfessorEntity professorEntity) {
        Professor professor = new Professor();
        professor.setName(professorEntity.getName());
        professor.setSurname(professorEntity.getSurname());
        professor.setId(professorEntity.getId());
        return professor;
    }

    public static ProfessorEntity mapProfessorToEntity(Professor professor) {
        ProfessorEntity professorEntity = new ProfessorEntity();
        professorEntity.setName(professor.getName());
        professorEntity.setSurname(professor.getSurname());
        if(professor.getId() != null){
            professorEntity.setId(professor.getId());
        }
        return professorEntity;
    }

    public static ArrayList<Professor> mapEntitiesToProfessors(List<ProfessorEntity> resultList) {
        ArrayList<Professor> professors = new ArrayList<>();
        for(ProfessorEntity professorEntity: resultList){
            professors.add(mapEntityToProfessor(professorEntity));
        }
        return professors;
    }
}
