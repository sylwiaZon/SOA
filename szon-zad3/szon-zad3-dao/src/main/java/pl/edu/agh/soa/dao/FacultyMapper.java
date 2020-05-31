package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.FacultyEntity;

public class FacultyMapper {
    public static FacultyEntity mapEntity(String name){
        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(name);
        return facultyEntity;
    }

    public static String mapFaculty(FacultyEntity facultyEntity){
        return facultyEntity.getName();
    }
}
