package com.example.Assignment3Final.controllers;

import com.example.Assignment3Final.models.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadStudentController extends EYPBaseController {

    /**
     * Loads the student information from students.txt into the arrays and dropboxes
     *
     * @param students      The array list of student objects.
     * @param studentNames1 Holds the names for the first dropbox on the Add Modules tab.
     * @param studentNames2 Holds the names for the second dropbox on the Report tab.
     */
    public LoadStudentController(ArrayList<Student> students, ComboBox<String> studentNames1, ComboBox<String> studentNames2) {
        this.students = students;
        this.studentNames1 = studentNames1;
        this.studentNames2 = studentNames2;
    }

    /**
     * @param event sets action for the button
     */
    @Override
    public void handle(ActionEvent event) {
        //Clear teh array
        students.removeAll(students);
        Path studentList = Paths.get("StudentList.txt");

        try {
            FileInputStream fis = new FileInputStream(studentList.toFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Student> readStudents = (ArrayList<Student>) ois.readObject();

            // Load the students into the array
            if (readStudents != null) {
                students.addAll(readStudents);
            }

            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        populateDropdowns();
    }
}

