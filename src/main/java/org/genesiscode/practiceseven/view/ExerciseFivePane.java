package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import org.genesiscode.practiceseven.service.ExerciseFive;
import org.genesiscode.practiceseven.view.row.five.RowInputData;

import java.util.List;

public class ExerciseFivePane extends MyPane {

    private static ExerciseFivePane exerciseFivePane;
    private final ExerciseFive exerciseFive;

    private TableView<RowInputData> tableInputData;

    public ExerciseFivePane() {
        super("EJERCICIO 5");
        exerciseFive = new ExerciseFive();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseFivePane getInstance() {
        return exerciseFivePane == null ? new ExerciseFivePane() : exerciseFivePane;
    }

    public void loadControls() {
        tableInputData = new TableView<>();
        buildTableInputData();
    }

    public void buildPane() {
        mainPane = new VBox(10, title, tableInputData);
        mainPane.setPadding(new Insets(30));
    }

    private void buildTableInputData() {
        TableColumn<RowInputData, Integer> colNumberOfPrograms =
                column("Numero de\nprogramas\nvendidos", "numberOfPrograms", 100);
        TableColumn<RowInputData, Double> colProbability =
                column("Probabilidad", "probability", 100);
        tableInputData.getColumns().addAll(List.of(colNumberOfPrograms, colProbability));
        tableInputData.setMaxWidth(210);
        tableInputData.setPrefHeight(175);
        tableInputData.setItems(exerciseFive.getListToTableInputData());
    }
}
