package org.genesiscode.practiceseven.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowMain extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new ExerciseFourPane().getMainPane());
        stage.setTitle("Practica 7");
        stage.setScene(scene);
        stage.show();
    }
}

