package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SaveStudentController extends EYPBaseController {

    /**
     * Saves the info that has been entered into the student.txt file.
     *
     * @param students The array list of student objects.
     */
    public SaveStudentController(ArrayList<Student> students){
        this.students = students;
    }

    /**
     * @param event sets action for the button
     */
    @Override
    public void handle(ActionEvent event) {
        // This will save the text file
        Path studentList = Paths.get("StudentList.txt");

        try {
            FileOutputStream fos = new FileOutputStream(studentList.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



