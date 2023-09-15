package com.example.Assignment3Final.models;

import java.io.Serializable;

/**
 * Adds the module and grade to a Student
 */
public class Module implements Serializable {
    // Name of the module
    String name;
    // Grade a certain student got in that module
    int grade;

    /**
     * Sets the name of a module and the grade a student got in it.
     *
     * @param name  Name of the module.
     * @param grade The grade a student got in that module.
     */
    public Module(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    /**
     * Gets name of the module
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the grade the student got in this module
     *
     * @return grade
     */
    public int getGrade() {
        return grade;
    }
}
