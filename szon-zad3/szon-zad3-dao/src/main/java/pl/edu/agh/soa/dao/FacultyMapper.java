package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.FacultyEntity;
import pl.edu.agh.soa.models.Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyMapper {
    public static FacultyEntity mapFacultyToEntity(Faculty faculty){
        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(faculty.getName());
        if(faculty.getId() != null){
            facultyEntity.setId(faculty.getId());
        }
        return facultyEntity;
    }

    public static Faculty mapEntityToFaculty(FacultyEntity facultyEntity){
        Faculty faculty= new Faculty();
        faculty.setName(facultyEntity.getName());
        faculty.setId(facultyEntity.getId());
        return faculty;
    }

    public static ArrayList<Faculty> mapEntitiesToFaculties(List<FacultyEntity> resultList) {
        ArrayList<Faculty> faculties = new ArrayList<>();
        for(FacultyEntity facultyEntity: resultList){
            faculties.add(mapEntityToFaculty(facultyEntity));
        }
        return faculties;
    }
}
