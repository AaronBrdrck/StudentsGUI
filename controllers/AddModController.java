package com.example.Assignment3Final.controllers;


import com.example.Assignment3Final.models.Module;
import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class AddModController extends EYPBaseController {
    TextField gradeField;
    TextField modField;
    ComboBox studentNames;

    /**
     * Creates the button to add a module to the Students module list.
     *
     * @Param gradeField    Takes the entered grade from the text field.
     * @Param modField      Takes the module name entered from the text field
     * @Param students      The Array list that keeps all the students
     * @Param studentNames  The Dropbox that houses all the student names
     */
    public AddModController(TextField gradeField, TextField modField, ArrayList<Student> students, ComboBox<String> studentNames){
        this.gradeField = gradeField;
        this.modField = modField;
        this.students = students;
        this.studentNames = studentNames;
    }

    /**
     * When button is pressed, it takes the int in gradeField and the text in modField and adds them to the module in the student object
     *
     * @param event Activates on click.
     */
    @Override
    public void handle(ActionEvent event) {
        // This will add the module and grade to the student
        int newGrade;
        try{
            newGrade = Integer.parseInt(gradeField.getText());
        }
        catch (NumberFormatException e){
            return;
        }
        Module newMod = new Module(modField.getText(), newGrade);
        for (Student student : students) {
            if (studentNames.getValue().equals(student.getName())) {
                student.addModule(newMod);
            }
        }
    }

}
