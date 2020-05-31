package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class StudentDao {
    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    public void addStudent(Student student){
        entityManager.persist(StudentMapper.mapStudentToEntity(student));
    }

    public Student getStudent(int albumNumber){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = criteriaBuilder.createQuery(StudentEntity.class);
        Root<StudentEntity> studentRoot = criteriaQuery.from(StudentEntity.class);
        criteriaQuery.select(studentRoot).where(criteriaBuilder.equal(studentRoot.get("album_number"), albumNumber));
        return StudentMapper.mapEntityToStudent(entityManager.createQuery(criteriaQuery).getSingleResult());
    }
}
