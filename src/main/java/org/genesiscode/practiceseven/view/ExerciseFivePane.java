package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practiceseven.service.ExerciseFive;
import org.genesiscode.practiceseven.service.utils.Util;
import org.genesiscode.practiceseven.view.row.five.RowInputData;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;

import java.util.List;

public class ExerciseFivePane extends MyPane {

    private static ExerciseFivePane exerciseFivePane;
    private final ExerciseFive exerciseFive;

    private TableView<RowInputData> tableInputData;
    private TableView<RowDataProcessed> programsSalesTable;
    private Button btnStart;

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
        buildTableRandomNumbers();

        btnAdd.setOnAction(actionEvent -> click_btn_add());
        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_btn_start());
    }

    private void click_btn_start() {
        programsSalesTable.setItems(exerciseFive.listOfIntervals());
        ExerciseFivePaneAssist.show(programsSalesTable);
    }

    private void click_btn_add() {
        List<Double> randomNumbers = Util.convertToList(txtRandomNumbers.getText());
        tableRandomNumbers.setItems(exerciseFive.loadRandomNumber(randomNumbers));
    }

    public void buildPane() {
        VBox randomNumberAndInputPane = new VBox(10, inputPane, tableRandomNumbers, btnStart);
        randomNumberAndInputPane.setFillWidth(false);
        randomNumberAndInputPane.setAlignment(Pos.CENTER);

        HBox pane = new HBox(20, randomNumberAndInputPane, tableInputData);
        pane.setFillHeight(false);
        pane.setAlignment(Pos.CENTER);

        mainPane = new VBox(10, title, pane);
        mainPane.setAlignment(Pos.CENTER);

        programsSalesTable = new TableView<>();
        buildProgramsSalesTable();
    }

    private void buildProgramsSalesTable() {
        TableColumn<RowDataProcessed, Double> colProbability =
                column("Probabilidad", "probability", 100);

        TableColumn<RowDataProcessed, Double> colAccumulated =
                column("Distribucion\nAcumulada", "accumulatedDistribution", 100);

        TableColumn<RowDataProcessed, String> colRange =
                column("Rangos de\n# aleatorios", "range", 100);

        TableColumn<RowDataProcessed, Integer> colData =
                column("Programas\nVendidos", "data", 100);

        programsSalesTable.getColumns().addAll(List.of(colProbability, colAccumulated, colRange, colData));
        programsSalesTable.setPrefHeight(170);
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
