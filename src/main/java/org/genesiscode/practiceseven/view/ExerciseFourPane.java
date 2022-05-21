package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practiceseven.view.row.four.RowInputData;

import java.util.List;

public class ExerciseFourPane extends MyPane {

    private static ExerciseFourPane exerciseFourPane;
    private TableView<RowInputData> tableRandomNumbers, tableOfTime, tableOfCustomerArrival;
    private TextField txtRandomNumbers;
    private Button btnAdd;

    public ExerciseFourPane() {
        super("EJERCICIO 4");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseFourPane getInstance() {
        return exerciseFourPane == null ? new ExerciseFourPane() : exerciseFourPane;
    }

    private void loadControls() {
        txtRandomNumbers = new TextField();
        txtRandomNumbers.setPrefColumnCount(20);
        btnAdd = new Button("Agregar");
        btnAdd.setOnAction(actionEvent -> click_btn_add());

        tableRandomNumbers = new TableView<>();
        buildTableRandomNumbers();
        tableOfTime = new TableView<>();
        buildTableOfTime();
        tableOfCustomerArrival = new TableView<>();
        buildTableOfCustomerArrival();
    }

    private void click_btn_add() {
        System.out.println("Agregar");
    }

    private void buildPane() {
        VBox inputPane = new VBox(10, new Label("Numeros Aleatorios"), txtRandomNumbers, btnAdd);
        VBox randomNumbersPane = new VBox(10, inputPane, tableRandomNumbers);
        randomNumbersPane.setFillWidth(false);
        randomNumbersPane.setAlignment(Pos.CENTER);
        VBox timePane = new VBox(10, new Label("Datos del tiempo de servicio"), tableOfTime);
        timePane.setFillWidth(false);
        VBox customerArrivalPane = new VBox(10, new Label("Datos de la llegada de los clientes"), tableOfCustomerArrival);
        customerArrivalPane.setFillWidth(false);
        VBox informationPane = new VBox(20, timePane, customerArrivalPane);
        mainPane = new VBox(10, title, new HBox(30, randomNumbersPane, informationPane));
        mainPane.setPadding(new Insets(30));
    }

    private void buildTableRandomNumbers() {
        TableColumn<RowInputData, Integer> colRow = column("Fila", "data", 50);
        TableColumn<RowInputData, Double> colRandomNumbers = column("Numeros\nAletorios", "value", 120);
        tableRandomNumbers.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableRandomNumbers.setPrefWidth(150);
        tableRandomNumbers.setPrefHeight(300);
    }

    private void buildTableOfTime() {
        TableColumn<RowInputData, Integer> colRow = column("Tiempo de\nservicio", "data", 90);
        TableColumn<RowInputData, Double> colRandomNumbers = column("Probabilidad\n(Frecuencia)", "value", 110);
        tableOfTime.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableOfTime.setPrefHeight(150);
        tableOfTime.setPrefWidth(200);
    }

    private void buildTableOfCustomerArrival() {
        TableColumn<RowInputData, Integer> colRow = column("Tiempo entre\nlas llegadas", "data", 120);
        TableColumn<RowInputData, Double> colRandomNumbers = column("Probabilidad\n(Frecuencia)", "value", 120);
        tableOfCustomerArrival.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableOfCustomerArrival.setPrefHeight(150);
        tableOfCustomerArrival.setPrefWidth(240);
    }
}
