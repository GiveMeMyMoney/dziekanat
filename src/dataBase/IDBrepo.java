package dataBase;

import model.Student;

import java.util.ArrayList;

/**
 * Created by Marcin on 2015-10-22.
 */
public interface IDBrepo {

    void putStudentToDB(Student student);
    ArrayList<Student> getAllStudentFromDB();

}
