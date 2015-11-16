package dataBase;

import model.StudentSecond;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Marcin on 2015-11-04.
 */
public class SecondDBrepo {
    private static Logger logger = Logger.getLogger(FirstDBrepo.class.getName());
    private Connection conn = null;
    private PreparedStatement prepStmt;

    private static volatile SecondDBrepo instance = null;

    /**
     * Singleton ktory tworzy tylko 1 instancje klasy na wszystkich watkach(synchronized).
     */
    public static SecondDBrepo getInstance() {
        if (instance == null) {
            synchronized (SecondDBrepo.class) {
                if (instance == null) {
                    logger.info("Tworze instancje SecondDBrepo");
                    instance = new SecondDBrepo();
                }
            }
        }
        return instance;
    }

    public SecondDBrepo() {
        try
        {
            logger.info("SecondDBrepo construct");
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:projekt3cz2.sqlite");
            logger.info("Success, connection with DB!");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    /**
     * metoda sluzaca do ladowania cz2. Student do BD2.
     * @param studentSecond
     */
    public boolean putStudentToDBsecond(StudentSecond studentSecond) {
        logger.info("putVehicleToDB: " + studentSecond.toString());
        try {
            prepStmt = conn.prepareStatement("insert into student2 values (null, ?, ?, ?, ?, ?);");
            //----//
            int i=0;
            prepStmt.setInt(++i, studentSecond.getIndex());
            prepStmt.setString(++i, studentSecond.getSpeciality());
            prepStmt.setInt(++i, studentSecond.getYears());
            prepStmt.setString(++i, studentSecond.getAddress());
            prepStmt.setString(++i, studentSecond.getCity());
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
    public ArrayList<StudentSecond> getAllStudentFromDBsecond() {
        logger.info("getAllContactFromDB");
        ResultSet result = null;
        ArrayList<StudentSecond> students = new ArrayList<>();
        try {
            prepStmt = conn.prepareStatement("SELECT * FROM student2");
            result = prepStmt.executeQuery();
            int id, index, years;
            String speciality, address, city;

            for(int i=0; result.next(); i++) {
                id = result.getInt("stud2_id");
                index = result.getInt("stud2_index");
                speciality = result.getString("stud2_speciality");
                years = result.getInt("stud2_years");
                address = result.getString("stud2_address");
                city = result.getString("stud2_city");
                students.add(new StudentSecond(id, index, years, speciality, address, city));
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
