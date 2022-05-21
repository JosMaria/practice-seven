package org.genesiscode.practiceseven.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowMain extends Application {

    @Override
    public void start(Stage stage) {
        VBox pane = new VBox(new Label("Jose Maria"));
        pane.setPrefWidth(700);
        pane.setPrefHeight(500);
        Scene scene = new Scene(pane);
        stage.setTitle("Practica 7");
        stage.setScene(scene);
        stage.show();
    }
}

