package model;

import java.util.logging.Logger;

/**
 * Created by Marcin on 2015-11-04.
 */
public class StudentFirst {

    int id, index;
    String name, lastname, university, faculty, field;

    public StudentFirst(int id, int index, String name, String lastname, String university, String faculty, String field) {
        this.id = id;
        this.index = index;
        this.lastname = lastname;
        this.name = name;
        this.university = university;
        this.faculty = faculty;
        this.field = field;
    }
    public StudentFirst(int index, String name, String lastname, String faculty, String university, String field) {
        this.index = index;
        this.name = name;
        this.lastname = lastname;
        this.faculty = faculty;
        this.university = university;
        this.field = field;
    }

    //GETTERs:
    public int getIndex() {
        return index;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public String getUniversity() {
        return university;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getField() {
        return field;
    }

    //SETTERs:
    public void setId(int id) {
        this.id = id;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    public void setField(String field) {
        this.field = field;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    //METODs:
    @Override
    public String toString() {
        return "StudentFirst{" +
                "id=" + id +
                ", index=" + index +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
