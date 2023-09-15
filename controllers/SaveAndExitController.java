package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Student;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class SaveAndExitController extends SaveStudentController {

    /**
     * This button on the alert box will save the contents to the students.txt file and then exit the program.
     *
     * @param students The array list of student objects.
     */
    public SaveAndExitController(ArrayList<Student> students) {
        super(students);
    }

    /**
     * @param actionEvent sets action for the button
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        Platform.exit();
    }
}
