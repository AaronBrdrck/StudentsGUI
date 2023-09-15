package com.example.Assignment3Final.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ExitForRealController extends EYPBaseController {

    /**
     * Sets the platform to exit on click
     *
     * @param actionEvent sets action for the button
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
    }
}

