package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class ListStudentController extends EYPBaseController {

    TextArea area;

    /**
     * Populates the text area with the contents of students.txt
     *
     * @param area      The text area for the add student tab.
     * @param students  The array list of student objects
     */
    public ListStudentController(TextArea area, ArrayList<Student> students){
        this.area = area;
        this.students = students;
    }

    /**
     * @param event sets action for the button
     */
    @Override
    public void handle(ActionEvent event) {
        // This will load the list of students
        area.setText("");
        // Goes through a loop as students
        for (Student student : students) {
            area.appendText(student.toString());
            area.appendText("\n");
        }
    }

}
