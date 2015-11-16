package fxmlController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Fasade;
import model.Student;
import model.StudentFirst;
import model.StudentSecond;


import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Controller implements Initializable {
    private static Logger logger = Logger.getLogger(Controller.class.getName());

    ///"slabe" ladowanie modelu na sztywno. Brak konstr.
    private Fasade model = Fasade.getInstance();
    //View mam bezposrednio z fxmla.

    ArrayList<Student> students = new ArrayList<>();

    ///FXML variable region
    @FXML private TextField etIndex, etField, etName, etSpeciality, etFaculty,
            etLastname, etYears, etCity, etUniversity, etAddress;
    @FXML private TableView<Student> tableViewStudent;
    @FXML TableColumn<Student,Integer> colIndex;
    @FXML TableColumn<Student,String> colName;
    @FXML TableColumn<Student,String> colLastName;
    @FXML TableColumn<Student,String> colUniversity;
    @FXML TableColumn<Student,String> colFaculty;
    @FXML TableColumn<Student,String> colField;
    @FXML TableColumn<Student,String> colSpeciality;
    @FXML TableColumn<Student,Integer> colYears;
    @FXML TableColumn<Student,String> colAddress;
    @FXML TableColumn<Student,String> colCity;
    //endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colIndex.setCellValueFactory(new PropertyValueFactory<>("Index"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        colUniversity.setCellValueFactory(new PropertyValueFactory<>("University"));
        colFaculty.setCellValueFactory(new PropertyValueFactory<>("Faculty"));
        colField.setCellValueFactory(new PropertyValueFactory<>("Field"));
        colSpeciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
        colYears.setCellValueFactory(new PropertyValueFactory<>("Years"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        setVehiclesArray();
    }

    //private metod region
    private void setVehiclesArray() {
        students = new ArrayList<>(model.getAllStudentFromDB());
        ObservableList<Student> data = FXCollections.observableArrayList(students);
        tableViewStudent.setItems(data);
    }


    private boolean validateInteger(String text)
    {
        if(text.matches("\\d*"))
            return false;
        else
            return true;
    }
    //endregion

    ///FXML metod region
    @FXML protected void btnAddStudent() {
        logger.info("proba buttona add");
        ArrayList<String> atributes = new ArrayList<>();
        if(validateInteger(etIndex.getText())) {
            JOptionPane.showMessageDialog(null, "Please set an Integer into column \"Index number\"");
            etIndex.setPromptText("Only Integer!");
            return;
        } else if (validateInteger(etYears.getText())) {
            JOptionPane.showMessageDialog(null, "Please set an Integer into column \"Years of study\"");
            etIndex.setPromptText("Only Integer!");
            return;
        }
        //first Student
        atributes.add(etIndex.getText());
        atributes.add(etName.getText());
        atributes.add(etLastname.getText());
        atributes.add(etUniversity.getText());
        atributes.add(etFaculty.getText());
        atributes.add(etField.getText());
        //second Student
        atributes.add(etYears.getText());
        atributes.add(etSpeciality.getText());
        atributes.add(etAddress.getText());
        atributes.add(etCity.getText());
        //****//
        if(atributes.size() != 0) { //nie wypelnione ZADNE pole.
            for (String string : atributes) {   //sprawdzam czy wypelnione WSZYSTKIE pola
                if (string.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all sections");
                    return;
                }
            }
            StudentFirst studentFirst = new StudentFirst(Integer.valueOf(atributes.get(0)), atributes.get(1), atributes.get(2), atributes.get(3), atributes.get(4), atributes.get(5));
            StudentSecond studentSecond = new StudentSecond(Integer.valueOf(atributes.get(0)), Integer.valueOf(atributes.get(6)), atributes.get(7), atributes.get(8), atributes.get(9));
            Student student = new Student(studentFirst, studentSecond);
            students.add(student);
            logger.info("Student: " + student.toString());
            //BD
            model.putStudentToDB(student);
            //widok
            setVehiclesArray();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all sections");
            return;
        }
    }
    //endregion

}

//how to add data into tableView javaFX stackoverflow
