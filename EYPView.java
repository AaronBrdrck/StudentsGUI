package com.example.Assignment3Final;

import com.example.Assignment3Final.models.Student;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;


public class EYPView extends Application {

    protected ArrayList<Student> students = new ArrayList<Student>();
    private ComboBox<String> studentNames;
    private ComboBox<String> studentNames2;

    public static void main(String[] args) {
        launch(args);

    }

    /**
     * Creates the display for the Assignment.
     *
     * @param primaryStage starts the display for the stage.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Assignment 1");

        // Create a combo box
        studentNames = new ComboBox<>();
        studentNames2 = new ComboBox<>();

        // Text Field Section
        TextField sNameTxt = new TextField();
        TextField sIDTxt = new TextField();
        TextField sDOBTxt = new TextField();
        TextField modField = new TextField();
        TextField gradeField = new TextField();


        // Text Area Section
        TextArea area = new TextArea();
        TextArea area2 = new TextArea();
        TextArea results = new TextArea();

        // Label Section
        Label sName = new Label("Student Name");
        Label sID = new Label("Student ID");
        Label DOB = new Label("Student Date of Birth");
        Label modlable = new Label("Add a Module");
        Label grade = new Label("Add a Grade");

        // Alert Section
        Alert a = new Alert(AlertType.NONE);

        // Button Section
        Button add = new Button();
        Button rmv = new Button();
        Button list = new Button();
        Button load = new Button();
        Button save = new Button();
        Button exit = new Button();
        Button exitfr = new Button();
        Button saveAndExit = new Button();
        Button addMod = new Button();
        Button loadResults = new Button();
        Button byName = new Button();
        Button byGrade = new Button();


        add.setText("Add");
        rmv.setText("Remove");
        list.setText("List");
        load.setText("Load");
        save.setText("Save");
        exit.setText("Exit");
        addMod.setText("Add");
        loadResults.setText("Load");
        byName.setText("Sort by Name");
        byGrade.setText("Sort by Grade");

        //Check each button for their functions
        add.setOnAction(new AddStudentController(sNameTxt, sDOBTxt, sIDTxt, students, studentNames, studentNames2));

        rmv.setOnAction(new RemoveStudentController(sIDTxt, students));

        list.setOnAction(new ListStudentController(area, students));

        save.setOnAction(new SaveStudentController(students));

        load.setOnAction(new LoadStudentController(students, studentNames, studentNames2));

        // Actually Exits the alert box
        exitfr.setOnAction(new ExitForRealController());

        // For Alert box
        saveAndExit.setOnAction(new SaveAndExitController(students));

        exit.setOnAction(new ExitStudentController(a));

        // Adds a module to the module section
        addMod.setOnAction(new AddModController(gradeField, modField, students, studentNames));

        // Loads the results
        loadResults.setOnAction(new LoadModuleController(area2, results, students, studentNames, studentNames2));

        // Sorts the Modules by name
        byName.setOnAction(new ByNameSortController(area2, results, students, studentNames, studentNames2));

        // Sorts the Modules by Grade
        byGrade.setOnAction(new ByGradeSortController(area2, results, students, studentNames, studentNames2));


        // This will pop up an extra save tab and then exit the program
        a.setAlertType(AlertType.CONFIRMATION);

        a.setContentText("Do you want to save before exiting? unsaved progress may be lost");

        // Stuff for the save button
        ((Button) a.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
        ((Button) a.getDialogPane().lookupButton(ButtonType.OK)).setOnAction(saveAndExit.getOnAction());

        //Stuff for the close action
        ((Button) a.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");
        ((Button) a.getDialogPane().lookupButton(ButtonType.CANCEL)).setOnAction(exitfr.getOnAction());


        // Hbox Section
        HBox hbSName = new HBox(3);
        hbSName.getChildren().addAll(sName, sNameTxt);

        HBox hbDOB = new HBox(3);
        hbDOB.getChildren().addAll(DOB, sDOBTxt);

        HBox hbSID = new HBox(3);
        hbSID.getChildren().addAll(sID, sIDTxt);

        HBox hbARL = new HBox(3);
        hbARL.getChildren().addAll(add, rmv, list);

        HBox hbLSE = new HBox(3);
        hbLSE.getChildren().addAll(load, save, exit);

        HBox hbArea = new HBox(1);
        hbArea.getChildren().addAll(area);

        HBox hbModule = new HBox(1);
        hbModule.getChildren().addAll(modField, modlable);

        HBox hbgrade = new HBox(1);
        hbModule.getChildren().addAll(gradeField, grade, addMod);

        HBox loadSort = new HBox(1);
        loadSort.getChildren().addAll(loadResults, byName, byGrade);

        //Vbox Section
        VBox vbTab1 = new VBox(10);
        vbTab1.getChildren().addAll(hbSName, hbDOB, hbSID, hbARL, hbArea, hbLSE);

        VBox vbTab2 = new VBox(10);
        vbTab2.getChildren().addAll(studentNames, hbModule, hbgrade);

        VBox vbTab3 = new VBox(10);
        vbTab3.getChildren().addAll(studentNames2, area2, loadSort, results);

        // Tab Section

        // Tab 1
        TabPane tabPane = new TabPane();
        Tab addTab = new Tab();
        addTab.setText("Add a Student");
        addTab.setContent(new Rectangle(200, 200, Color.LIGHTSTEELBLUE));
        addTab.setContent(vbTab1);
        tabPane.getTabs().add(addTab);

        // Tab 2
        Tab moduleTab = new Tab();
        moduleTab.setText("Add a Module");
        moduleTab.setContent(new Rectangle(200, 200, Color.LIGHTSTEELBLUE));
        moduleTab.setContent(vbTab2);
        tabPane.getTabs().add(moduleTab);

        // Tab 3
        Tab recordTab = new Tab();
        recordTab.setText("View Records");
        recordTab.setContent(new Rectangle(200, 200, Color.LIGHTSTEELBLUE));
        recordTab.setContent(vbTab3);
        tabPane.getTabs().add(recordTab);


        StackPane root = new StackPane();
        root.getChildren();
        primaryStage.setScene(new Scene(tabPane, 300, 250));
        primaryStage.show();

        // Loads on startup
        load.fire();
    }


}