package com.example.Assignment3Final.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  Saves a student's name, Date of Birth, ID and current semester
 */
public class Student implements Serializable {
    //Students name
    String name;
    //Students date of birth
    String dob;
    //students ID
    String id;
    //students current semester
    String semester;
    //Stores the array list of modules
    protected ArrayList<Module> modules = new ArrayList<Module>();

    /**
     * Sets the information for the student
     *
     * @param name      A student's name.
     * @param dob       A student's date of birth.
     * @param id        A student's student ID.
     * @param semester  The semester a student is in.
     */
    public Student(String name, String dob, String id, String semester){
        this.name = name;
        this.dob = dob;
        this.id = id;
        this.semester = semester;

    }

    /**
     * Turns the information into a string
     *
     * @return the student's name, date of birth and ID
     */
    public String toString(){
        return name + "\t" + dob + "\t" + id + "\t" + semester;
    }

    /**
     * Gets a student's name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets a student's ID.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets a student's date of birth
     *
     * @return dob
     */
    public String getDob(){
        return dob;
    }

    /**
     * Gets the semester a student is in
     *
     * @return semester
     */
    public String getSemester() {return semester;}

    /**
     * Adds a module to the students module array
     *
     * @param mod the name and grade of a student's module
     */
    public void addModule(Module mod){
        modules.add(mod);
    }

    /**
     * Gets the list of a student's modules
     *
     * @return modules The array list of modules and grades.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }

    /**
     * Sorts the array list of student's modules on the text area in alphabetical order
     */
    public void sortModulesByName(){
        Collections.sort(this.modules, (mod1, mod2) -> mod1.getName().compareToIgnoreCase(mod2.getName()));
    }

    /**
     * Sorts the array list of student's modules on the text area by the grade they received in that module.
     */
    public void sortModulesByGrade() {
        Collections.sort(this.modules, (mod1, mod2) -> mod2.getGrade() - mod1.getGrade());
    }
}
