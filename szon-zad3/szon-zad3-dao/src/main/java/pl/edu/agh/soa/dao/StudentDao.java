package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Faculty;
import pl.edu.agh.soa.models.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;

@Stateless
public class StudentDao {
    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    public void addStudent(Student student, Faculty faculty){
        entityManager.persist(StudentMapper.mapStudentToEntity(student, faculty));
    }

    public ArrayList<Student> getStudents(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = criteriaBuilder.createQuery(StudentEntity.class);
        Root<StudentEntity> studentRoot = criteriaQuery.from(StudentEntity.class);
        criteriaQuery.select(studentRoot);
        return StudentMapper.mapEntitiesToStudents(entityManager.createQuery(criteriaQuery).getResultList());
    }

    public Student getStudentByAlbumNumber(int albumNumber){
        return  StudentMapper.mapEntityToStudent(entityManager.find(StudentEntity.class, albumNumber));
    }

    public Student getStudentByFaculty(Faculty faculty){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = criteriaBuilder.createQuery(StudentEntity.class);
        Root<StudentEntity> studentRoot = criteriaQuery.from(StudentEntity.class);
        criteriaQuery.select(studentRoot).where(criteriaBuilder.equal(studentRoot.get("faculty_id"), faculty.getId()));
        return StudentMapper.mapEntityToStudent(entityManager.createQuery(criteriaQuery).getSingleResult());
    }

    public boolean deleteStudent(int albumNumber){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete delete = criteriaBuilder.createCriteriaDelete(StudentEntity.class);
        Root root = delete.from(StudentEntity.class);
        delete.where(criteriaBuilder.equal(root.get("albumNumber"), albumNumber));
        Query query = entityManager.createQuery(delete);
        int rowsNum = query.executeUpdate();
        return rowsNum != 0;
    }

    public void updateStudent(Student student, Student studentToChange, int albumNumber, Faculty faculty){
        StudentEntity studentEntity = StudentMapper.mapStudentToEntity(studentToChange);
        if(student.getName() != null){
            studentEntity.setName(student.getName());
        }
        if(student.getSurname() != null){
            studentEntity.setSurname(student.getSurname());
        }
        if(faculty != null){
            studentEntity.setFacultyEntity(FacultyMapper.mapFacultyToEntity(faculty));
        }
        entityManager.merge(studentEntity);
    }

    public void addCourseToStudent(Student student, Course course){
        StudentEntity studentEntity = StudentMapper.mapStudentToEntity(student);
        CourseEntity courseEntity = CourseMapper.mapCourseToEntity(course);
        studentEntity.addCourse(courseEntity);
        entityManager.merge(studentEntity);
    }

}
