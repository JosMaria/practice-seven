package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class ExerciseFivePane extends MyPane {

    private static ExerciseFivePane exerciseFivePane;

    public ExerciseFivePane() {
        super("EJERCICIO 5");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseFivePane getInstance() {
        return exerciseFivePane == null ? new ExerciseFivePane() : exerciseFivePane;
    }

    public void loadControls() {

    }

    public void buildPane() {
        mainPane = new VBox(10, title);
        mainPane.setPadding(new Insets(30));
    }
}
