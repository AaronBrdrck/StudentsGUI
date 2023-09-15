package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public abstract class EYPBaseController implements EventHandler<ActionEvent> {
    ComboBox<String> studentNames1;
    ComboBox<String> studentNames2;
    ArrayList<Student> students;

    /**
     * Makes sure the dropdowns have the students names in them
     */
    //Fills the dropdown boxes
    protected void populateDropdowns() {
        studentNames1.getItems().clear();
        studentNames2.getItems().clear();
        for (Student student : students) {
            studentNames1.getItems().add(student.getName());
            studentNames2.getItems().add(student.getName());
        }
    }

    /**
     * Adds the students information to the array.
     *
     * @return a new student object
     */
    protected Student getStudent() {
        if (studentNames2.getValue() == null) return null;
        for (Student student : students) {
            if (studentNames2.getValue().equals(student.getName())) {
                return student;
            }
        }
        return null;
    }
}
