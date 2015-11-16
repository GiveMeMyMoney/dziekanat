package dataBase;


import model.StudentFirst;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Marcin on 2015-10-21.
 */
public class FirstDBrepo {
    private static Logger logger = Logger.getLogger(FirstDBrepo.class.getName());
    private Connection conn = null;
    private PreparedStatement prepStmt;

    private static volatile FirstDBrepo instance = null;

    /**
     * Singleton ktory tworzy tylko 1 instancje klasy na wszystkich watkach(synchronized).
     */
    public static FirstDBrepo getInstance() {
        if (instance == null) {
            synchronized (FirstDBrepo.class) {
                if (instance == null) {
                    logger.info("Tworze instancje FirstDBrepo");
                    instance = new FirstDBrepo();
                }
            }
        }
        return instance;
    }

    public FirstDBrepo() {
        try
        {
            logger.info("FirstDBrepo construct");
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:projekt3.sqlite");
            logger.info("Success, connection with DB!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    /**
     * metoda sluzaca do ladowania cz1. Student do BD1.
     * @param studentFirst
     */
    public boolean putStudentToDBfirst(StudentFirst studentFirst) {
        logger.info("putVehicleToDB: " + studentFirst.toString());
        try {
            prepStmt = conn.prepareStatement("insert into student1 values (null, ?, ?, ?, ?, ?, ?);");
            //----//
            int i=0;
            prepStmt.setInt(++i, studentFirst.getIndex());
            prepStmt.setString(++i, studentFirst.getName());
            prepStmt.setString(++i, studentFirst.getLastname());
            prepStmt.setString(++i, studentFirst.getUniversity());
            prepStmt.setString(++i, studentFirst.getFaculty());
            prepStmt.setString(++i, studentFirst.getField());
            //----//
            prepStmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * metoda pobierajaca wszystkie rekordy z BD1.
     * @return
     */
    public ArrayList<StudentFirst> getAllStudentFromDBfirst() {
        logger.info("getAllContactFromDB");
        ResultSet result = null;
        ArrayList<StudentFirst> students = new ArrayList<>();
        try {
            prepStmt = conn.prepareStatement("SELECT * FROM student1");
            result = prepStmt.executeQuery();
            int id, index;
            String name, surname, university, faculty, field;

            for(int i=0; result.next(); i++) {
                id = result.getInt("stud1_id");
                index = result.getInt("stud1_index");
                name = result.getString("stud1_name");
                surname = result.getString("stud1_lastname");
                university = result.getString("stud1_university");
                faculty = result.getString("stud1_faculty");
                field = result.getString("stud1_field");
                students.add(new StudentFirst(id, index, name, surname, university, faculty, field));
                logger.info(students.get(i).toString());
            }

            if(students.size() == 0) {
                logger.info("Pusta BD?");
            }
            return students;
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1);
            e1.printStackTrace();
            return null;
        }
    }




}