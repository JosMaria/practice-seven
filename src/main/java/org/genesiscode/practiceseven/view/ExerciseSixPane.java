package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class ExerciseSixPane extends MyPane {

    private static ExerciseSixPane exerciseSixPane;

    public ExerciseSixPane() {
        super("EJERCICIO 6");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseSixPane getInstance() {
        return exerciseSixPane == null ? new ExerciseSixPane() : exerciseSixPane;
    }

    public void loadControls() {

    }

    public void buildPane() {
        mainPane = new VBox(10, title);
        mainPane.setPadding(new Insets(30));
    }
}
