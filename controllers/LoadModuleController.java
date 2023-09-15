package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Module;
import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class LoadModuleController extends EYPBaseController {

    TextArea area2;
    TextArea results;

    /**
     *  Loads the content from the module section of the student objects
     *
     * @param area2         Holds the text area for the Report tab that shows the selected student's information.
     * @param results       Holds the text area for the Report tab that shows the selected student's modules and grades.
     * @param students      The array list of student objects.
     * @param studentNames1 Holds the names for the first dropbox on the Add Modules tab.
     * @param studentNames2 Holds the names for the second dropbox on the Report tab.
     */
    public LoadModuleController(TextArea area2, TextArea results, ArrayList<Student> students, ComboBox<String> studentNames1, ComboBox<String> studentNames2){
        this.area2 = area2;
        this.results = results;
        this.students = students;
        this.studentNames1 = studentNames1;
        this.studentNames2 = studentNames2;
    }

    /**
     * @param event sets action for the button
     */
    @Override
    public void handle(ActionEvent event) {
        // This will load the name, dob, id, module and results into the text field
        area2.setText("");
        results.setText("");
        Student student = getStudent();
        if (student == null) return;
        area2.appendText(student.getName());
        area2.appendText(" ");
        area2.appendText(student.getDob());
        area2.appendText(" ");
        area2.appendText(student.getId());
        area2.appendText(" ");

        for (Module mod : student.getModules()) {
            results.appendText(mod.getName());
            results.appendText(" ");
            results.appendText(String.valueOf(mod.getGrade()));
            results.appendText("\n");
        }
    }

}
