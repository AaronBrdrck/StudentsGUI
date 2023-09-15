package com.example.Assignment3Final.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class ExitStudentController extends EYPBaseController {
    Alert a;

    /**
     * Creates the Alert box for the exit button to make sure the user has a chance to save
     *
     * @param a The alert box for the Exit button.
     */
    public ExitStudentController(Alert a){
        this.a = a;

    }

    /**
     * @param event sets action for the button
     */
    @Override
    public void handle(ActionEvent event) {
        a.show();
    }

}
