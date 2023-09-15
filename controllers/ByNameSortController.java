package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class ByNameSortController extends LoadModuleController {

    /**
     * @param area2         Holds the text area for the Report tab that shows the selected student's information.
     * @param results       Holds the text area for the Report tab that shows the selected student's modules and grades.
     * @param students      The array list of student objects.
     * @param studentNames1 Holds the names for the first dropbox on the Add Modules tab.
     * @param studentNames2 Holds the names for the second dropbox on the Report tab.
     */
    public ByNameSortController(TextArea area2, TextArea results, ArrayList<Student> students, ComboBox<String> studentNames1, ComboBox<String> studentNames2){
        super(area2,results,students, studentNames1, studentNames2);
    }

    /**
     * Controls the button
     *
     * @param actionEvent sets action for the button
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Student student = getStudent();
        if (student == null) return;
        student.sortModulesByName();
        super.handle(actionEvent);
    }

}
