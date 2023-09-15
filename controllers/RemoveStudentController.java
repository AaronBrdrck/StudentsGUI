package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class RemoveStudentController extends EYPBaseController {
    TextField studentIDField;

    /**
     * Uses the student ID field to remove all of a students information from the file.
     *
     * @param studentIDField Contains the students ID that has been entered
     * @param students       The array list of student objects.
     */
    public RemoveStudentController(TextField studentIDField, ArrayList<Student> students){
        this.studentIDField = studentIDField;
        this.students = students;
    }

    /**
     * @param actionEvent sets action for the button
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // This will Remove the students from the file using their student ID
        students.removeIf(student -> student.getId().equals(studentIDField.getText()));
        populateDropdowns();
    }
}
