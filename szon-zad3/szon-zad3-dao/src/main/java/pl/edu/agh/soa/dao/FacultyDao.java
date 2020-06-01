package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.FacultyEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.models.Faculty;
import pl.edu.agh.soa.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

@Stateless
public class FacultyDao {
    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    public void addFaculty(Faculty faculty){
        entityManager.persist(FacultyMapper.mapFacultyToEntity(faculty));
    }

    public ArrayList<Faculty> getFaculties(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FacultyEntity> criteriaQuery = criteriaBuilder.createQuery(FacultyEntity.class);
        Root<FacultyEntity> facultyEntityRoot = criteriaQuery.from(FacultyEntity.class);
        criteriaQuery.select(facultyEntityRoot);
        return FacultyMapper.mapEntitiesToFaculties(entityManager.createQuery(criteriaQuery).getResultList());
    }

    public Faculty getFacultyByName(String name){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FacultyEntity> criteriaQuery = criteriaBuilder.createQuery(FacultyEntity.class);
        Root<FacultyEntity> facultyEntityRoot = criteriaQuery.from(FacultyEntity.class);
        criteriaQuery.select(facultyEntityRoot).where(criteriaBuilder.equal(facultyEntityRoot.get("name"), name));
        return FacultyMapper.mapEntityToFaculty(entityManager.createQuery(criteriaQuery).getSingleResult());
    }

    public Faculty getFacultyById(int id){
        return FacultyMapper.mapEntityToFaculty(entityManager.find(FacultyEntity.class, id));
    }
}
