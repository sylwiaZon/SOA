package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class CourseMapper {
    public static Course mapEntityToCourse(CourseEntity courseEntity){
        Course course = new Course();
        course.setEctsPoints(courseEntity.getEctsPoints());
        course.setHours(courseEntity.getHours());
        course.setName(courseEntity.getName());
        course.setProfesorName(ProfessorMapper.mapEntityToProfessor(courseEntity.getProfessorEntity()).getName());
        course.setProfesorSurname(ProfessorMapper.mapEntityToProfessor(courseEntity.getProfessorEntity()).getSurname());
        return course;
    }

    public static CourseEntity mapCourseToEntity(Course course){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setEctsPoints(course.getEctsPoints());
        courseEntity.setHours(course.getHours());
        courseEntity.setName(course.getName());
        courseEntity.setProfessorEntity(ProfessorMapper.mapProfessorToEntity(new Professor(course.getProfesorName(), course.getProfesorSurname())));
        return courseEntity;
    }

    public static ArrayList<Course> getCoursesFromEntities(List<CourseEntity> courseEntities){
        ArrayList<Course> courses = new ArrayList<>();
        for(CourseEntity courseEntity: courseEntities){
            courses.add(mapEntityToCourse(courseEntity));
        }
        return courses;
    }

    public static ArrayList<CourseEntity> getEntitiesFromCourses(ArrayList<Course> courses){
        ArrayList<CourseEntity> courseEntities = new ArrayList<>();
        for(Course course: courses){
            courseEntities.add(mapCourseToEntity(course));
        }
        return courseEntities;
    }
}
