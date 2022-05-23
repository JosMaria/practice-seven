package org.genesiscode.practiceseven.view;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practiceseven.service.ExerciseFive;
import org.genesiscode.practiceseven.service.utils.Util;
import org.genesiscode.practiceseven.view.row.five.RowInputData;
import org.genesiscode.practiceseven.view.row.five.RowResult;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;

import java.util.List;

public class ExerciseFivePane extends MyPane {

    private static ExerciseFivePane exerciseFivePane;
    private final ExerciseFive exerciseFive;

    private TableView<RowInputData> tableInputData;
    private TableView<RowDataProcessed> programsSalesTable;
    private TableView<RowResult> resultTable;
    private Button btnStart;
    private TextField txtProduce, txtSales, txtSimulatedGames, txtQuantity;

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

        programsSalesTable = buildDataProcessedTable("Programas\nVendidos");

        resultTable = new TableView<>();
        buildResultTable();

        txtProduce = getTextField();
        txtSales = getTextField();
        txtSimulatedGames = getTextField();
        txtQuantity = getTextField();
    }

    private TextField getTextField() {
        TextField textField = new TextField();
        textField.setPrefColumnCount(4);
        return textField;
    }

    private void click_btn_start() {
        programsSalesTable.setItems(exerciseFive.listOfIntervals());
        // 0.8, 2, 2600, 10
        double produce = Double.parseDouble(txtProduce.getText());
        double sell = Double.parseDouble(txtSales.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        int simulatedGames = Integer.parseInt(txtSimulatedGames.getText());
        resultTable.setItems(exerciseFive.getListResult(produce, sell, quantity, simulatedGames));
        ExerciseFivePaneAssist.show(programsSalesTable, resultTable, exerciseFive.getTotal());
    }

    private void click_btn_add() {
        List<Double> randomNumbers = Util.convertToList(txtRandomNumbers.getText());
        tableRandomNumbers.setItems(exerciseFive.loadRandomNumbers(randomNumbers));
    }

    public void buildPane() {
        VBox randomNumberAndInputPane = new VBox(10, inputPane, tableRandomNumbers, btnStart);
        randomNumberAndInputPane.setFillWidth(false);
        randomNumberAndInputPane.setAlignment(Pos.CENTER);

        VBox inputDataPane = new VBox(10,
                new HBox(10, new Label("Produce"), txtProduce),
                new HBox(10, new Label("Vende"), txtSales),
                new HBox(10, new Label("Juegos Simulados"), txtSimulatedGames),
                new HBox(10, new Label("Cantidad"), txtQuantity), tableInputData);
        inputDataPane.setAlignment(Pos.TOP_LEFT);

        HBox pane = new HBox(20, randomNumberAndInputPane, inputDataPane);
        pane.setFillHeight(false);
        pane.setAlignment(Pos.CENTER);

        mainPane = new VBox(10, title, pane);
        mainPane.setAlignment(Pos.CENTER);
    }

    private void buildResultTable() {
        TableColumn<RowResult, Integer> colDay = column("Dia", "day", 50);
        TableColumn<RowResult, Double> colRandomNumber = column("#Aleatorio", "randomNumber", 100);
        TableColumn<RowResult, Integer> colDemand = column("Demanda", "demand", 100);
        TableColumn<RowResult, Integer> colRevenue = column("Ganancia", "revenue", 100);
        resultTable.getColumns().addAll(List.of(colDay, colRandomNumber, colDemand, colRevenue));
        resultTable.setPrefHeight(190);
        resultTable.setPrefWidth(350);
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
