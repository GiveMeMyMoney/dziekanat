package model;

import java.util.logging.Logger;

/**
 * Created by Marcin on 2015-11-04.
 */
public class Student {

    StudentFirst studentFirst;
    StudentSecond studentSecond;

    public Student(StudentFirst studentFirst, StudentSecond studentSecond) {
        this.studentFirst = studentFirst;
        this.studentSecond = studentSecond;
    }

    //GETTERs from STUDENT1
    public int getIndex() {
        return studentFirst.getIndex();
    }
    public String getName() {
        return studentFirst.getName();
    }
    public String getLastname() {
        return studentFirst.getLastname();
    }
    public String getUniversity() {
        return studentFirst.getUniversity();
    }
    public String getFaculty() {
        return studentFirst.getFaculty();
    }
    public String getField() {
        return studentFirst.getField();
    }

    //GETTERs from STUDENT2
    /*public int getIndex() {
        return index;
    }*/
    public String getSpeciality() {
        return studentSecond.getSpeciality();
    }
    public int getYears() {
        return studentSecond.getYears();
    }
    public String getAddress() {
        return studentSecond.getAddress();
    }
    public String getCity() {
        return studentSecond.getCity();
    }



    //GETTERs and SETTERs for reference
    public StudentFirst getStudentFirst() {
        return studentFirst;
    }
    public void setStudentFirst(StudentFirst studentFirst) {
        this.studentFirst = studentFirst;
    }
    public StudentSecond getStudentSecond() {
        return studentSecond;
    }
    public void setStudentSecond(StudentSecond studentSecond) {
        this.studentSecond = studentSecond;
    }


    //METODs:
    @Override
    public String toString() {
        return "Student{" +
                "studentFirst=" + studentFirst.toString() +
                ", studentSecond=" + studentSecond.toString() +
                '}';
    }
}
