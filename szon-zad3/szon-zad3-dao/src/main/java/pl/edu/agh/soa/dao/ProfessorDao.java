package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.ProfessorEntity;
import pl.edu.agh.soa.models.Professor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

@Stateless
public class ProfessorDao {
    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    public void addProfessor(Professor professor){
        entityManager.persist(ProfessorMapper.mapProfessorToEntity(professor));
    }

    public ArrayList<Professor> getProfessors(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProfessorEntity> criteriaQuery = criteriaBuilder.createQuery(ProfessorEntity.class);
        Root<ProfessorEntity> professorEntityRoot = criteriaQuery.from(ProfessorEntity.class);
        criteriaQuery.select(professorEntityRoot);
        return ProfessorMapper.mapEntitiesToProfessors(entityManager.createQuery(criteriaQuery).getResultList());
    }

    public Professor getProfessorByName(String name, String surname){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProfessorEntity> criteriaQuery = criteriaBuilder.createQuery(ProfessorEntity.class);
        Root<ProfessorEntity> professorEntityRoot = criteriaQuery.from(ProfessorEntity.class);
        criteriaQuery.select(professorEntityRoot).where(criteriaBuilder.and(criteriaBuilder.equal(professorEntityRoot.get("name"), name),criteriaBuilder.equal(professorEntityRoot.get("surname"), surname)));
        return ProfessorMapper.mapEntityToProfessor(entityManager.createQuery(criteriaQuery).getSingleResult());
    }

    public Professor getProfessorById(int id){
        return ProfessorMapper.mapEntityToProfessor(entityManager.find(ProfessorEntity.class, id));
    }
}
