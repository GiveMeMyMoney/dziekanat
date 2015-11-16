package model;

import dataBase.FirstDBrepo;
import dataBase.IDBrepo;
import dataBase.SecondDBrepo;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Marcin on 2015-11-04.
 */
public class Fasade implements IDBrepo {
    private static Logger logger = Logger.getLogger(Fasade.class.getName());

    private static volatile Fasade instance = null;
    //private static DBrepo dBrepo = null;

    public static Fasade getInstance() {
        if (instance == null) {
            synchronized (Fasade.class) {
                if (instance == null) {
                    logger.info("Tworze instancje KsiazkiTelefonicznej");
                    instance = new Fasade();
                }
            }
        }
        return instance;
    }

    /**
     * Konstruktor.
     */
    private Fasade() {
    }

    /**
     * Metoda obslugujaca pobieranie wszystkich studentow z obu BD implementowana z interfejsu
     * @see IDBrepo
     * @return
     */
    @Override
    public ArrayList<Student> getAllStudentFromDB() {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<StudentFirst> studentsFirst = new ArrayList<>();
        ArrayList<StudentSecond> studentsSecond = new ArrayList<>();
        studentsFirst = FirstDBrepo.getInstance().getAllStudentFromDBfirst();
        studentsSecond = SecondDBrepo.getInstance().getAllStudentFromDBsecond();
        if(studentsFirst.size()==0 || studentsSecond.size()==0) {
            logger.info("Pusta BD?");
            return null;
        } else {
            for (int i=0; i<studentsFirst.size() && i<studentsSecond.size(); ++i) {
                students.add(new Student(studentsFirst.get(i), studentsSecond.get(i)));
                logger.info("Student caly: " + students.get(i).toString());

            }
            return students;
        }
    }

    /**
     * Metoda obslugujaca zapisywanie studenta do obu BD implementowana z interfejsu
     * @see IDBrepo
     * @param student
     */
    @Override
    public void putStudentToDB(Student student) {
        if (student != null) {
            boolean firstFlag = FirstDBrepo.getInstance().putStudentToDBfirst(student.getStudentFirst());
            if (!firstFlag) {
                logger.info("Blad przy ladowaniu do firstDB");
            } else {
                boolean secondFlag = SecondDBrepo.getInstance().putStudentToDBsecond(student.getStudentSecond());
                if (!secondFlag) {
                    logger.info("Blad przy ladowaniu do secondDB");
                }
            }
        }
    }


}
