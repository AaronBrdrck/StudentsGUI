package com.example.Assignment3Final.controllers;


import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class AddStudentController extends EYPBaseController {

    TextField studentNameField;
    TextField studentDOBField;
    TextField studentIDField;

    /**
     * Adds a student and their details to the array list
     *
     * @Param studentNameField  Stores the entered name into a text field.
     * @Param studentDOBField   Stores the entered Date of Birth into a text field.
     * @Param studentIDField    Stores the entered student ID into a text field.
     * @Param students          Adds the students data into the array list of student objects.
     * @Param studentNames1     Adds the students names into the dropbox for the Add Module tab.
     * @Param studentNames2     Adds the students names into the dropbox for the Show Records tab.
     */
    public AddStudentController(TextField studentNameField, TextField studentDOBField, TextField studentIDField, ArrayList<Student> students, ComboBox<String> studentNames1, ComboBox<String> studentNames2) {
        this.studentNameField = studentNameField;
        this.studentDOBField = studentDOBField;
        this.studentIDField = studentIDField;
        this.students = students;
        this.studentNames1 = studentNames1;
        this.studentNames2 = studentNames2;
    }

    /**
     * Adds the students names, dates of brith and IDs into the array, clears the text field and the populates the dropdown menu
     *
     * @param actionEvent Activates when button is pressed
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // This will add whatever name, id and dob is entered into the fields into the txt file
        Student newStudent = new Student(studentNameField.getText(), studentDOBField.getText(), studentIDField.getText());
        students.add(newStudent);
        studentNameField.clear();
        studentDOBField.clear();
        studentIDField.clear();
        this.populateDropdowns();
    }
}
