package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.jpa.FacultyEntity;
import pl.edu.agh.soa.jpa.ProfessorEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Faculty;
import pl.edu.agh.soa.models.Professor;
import pl.edu.agh.soa.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CourseDao {
    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    public void addCourse(Course course, Professor professor){
        entityManager.persist(CourseMapper.mapCourseToEntity(course, professor));
    }

    public ArrayList<Course> getCourses(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CourseEntity> criteriaQuery = criteriaBuilder.createQuery(CourseEntity.class);
        Root<CourseEntity> courseEntityRoot = criteriaQuery.from(CourseEntity.class);
        criteriaQuery.select(courseEntityRoot);
        return CourseMapper.mapEntitiesToCourses(entityManager.createQuery(criteriaQuery).getResultList());
    }

    public Course getCourseByName(String name){
        return CourseMapper.mapEntityToCourse(getCourseEntityByName(name));
    }

    public Course getCourseById(int id){
        return CourseMapper.mapEntityToCourse(entityManager.find(CourseEntity.class, id));
    }

    public void addStudentToCourse(Student student, Course course){
        CourseEntity courseEntity = CourseMapper.mapCourseToEntity(course);
        courseEntity.addStudent(StudentMapper.mapStudentToEntity(student));
        entityManager.persist(courseEntity);
    }

    public ArrayList<Student> getStudentsForCourse(String name){
        CourseEntity courseEntity = getCourseEntityByName(name);
        List<StudentEntity> studentEntities = courseEntity.getStudentEntities();
        return StudentMapper.mapEntitiesToStudents(studentEntities);
    }

    private CourseEntity getCourseEntityByName(String name){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CourseEntity> criteriaQuery = criteriaBuilder.createQuery(CourseEntity.class);
        Root<CourseEntity> courseEntityRoot = criteriaQuery.from(CourseEntity.class);
        criteriaQuery.select(courseEntityRoot).where(criteriaBuilder.equal(courseEntityRoot.get("name"), name));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
