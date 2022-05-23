package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practiceseven.service.ExerciseFour;
import org.genesiscode.practiceseven.service.utils.Util;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;
import org.genesiscode.practiceseven.view.row.four.RowRandomNumbers;
import org.genesiscode.practiceseven.view.row.four.RowResult;

import java.util.List;

public class ExerciseFourPane extends MyPane {

    private static ExerciseFourPane exerciseFourPane;
    private final ExerciseFour exerciseFour;
    private TableView<RowRandomNumbers> tableOfTime, tableOfCustomerArrival;
    private TableView<RowDataProcessed> tableDataOfTime, tableDataOfCustomerArrival;
    private TableView<RowResult> tableResult;
    private Button btnStart;

    public ExerciseFourPane() {
        super("EJERCICIO 4");
        exerciseFour = new ExerciseFour();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseFourPane getInstance() {
        return exerciseFourPane == null ? new ExerciseFourPane() : exerciseFourPane;
    }

    private void loadControls() {
        btnAdd.setOnAction(actionEvent -> click_btn_add());

        buildTableRandomNumbers();
        tableOfTime = new TableView<>();
        buildTableOfTime();
        tableOfCustomerArrival = new TableView<>();
        buildTableOfCustomerArrival();

        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_btn_start());

        tableDataOfTime = new TableView<>();
        buildTableDataOfTime("Tiempo\nServicio", tableDataOfTime);
        tableDataOfCustomerArrival = new TableView<>();
        buildTableDataOfTime("T entre\nllegadas", tableDataOfCustomerArrival);

        tableResult = new TableView<>();
        buildTableResult();
    }

    private void click_btn_add() {
        List<Double> randomNumbers = Util.convertToList(txtRandomNumbers.getText());
        tableRandomNumbers.setItems(exerciseFour.loadRandomNumbers(randomNumbers));
    }

    private void click_btn_start() {
        tableDataOfTime.setItems(exerciseFour.getListToTableOf(exerciseFour.getListToTableOfTime()));
        tableDataOfCustomerArrival.setItems(exerciseFour.getListToTableOf(exerciseFour.getListToTableOfCustomerArrival()));
        ExerciseFourPaneAssist.show(tableDataOfTime, tableDataOfCustomerArrival, tableResult);
        tableResult.setItems(exerciseFour.getListResult(tableDataOfTime.getItems(), tableDataOfCustomerArrival.getItems()));
    }

    private void buildPane() {
        VBox randomNumbersPane = new VBox(10, inputPane, tableRandomNumbers, btnStart);
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

    private void buildTableOfTime() {
        TableColumn<RowRandomNumbers, Integer> colRow = column("Tiempo de\nservicio", "data", 80);
        TableColumn<RowRandomNumbers, Double> colRandomNumbers = column("Probabilidad\n(Frecuencia)", "value", 110);
        tableOfTime.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableOfTime.setPrefHeight(160);
        tableOfTime.setPrefWidth(220);
        tableOfTime.setItems(exerciseFour.getListToTableOfTime());
    }

    private void buildTableOfCustomerArrival() {
        TableColumn<RowRandomNumbers, Integer> colRow = column("Tiempo entre\nlas llegadas", "data", 120);
        TableColumn<RowRandomNumbers, Double> colRandomNumbers = column("Probabilidad\n(Frecuencia)", "value", 120);
        tableOfCustomerArrival.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableOfCustomerArrival.setPrefHeight(160);
        tableOfCustomerArrival.setPrefWidth(260);
        tableOfCustomerArrival.setItems(exerciseFour.getListToTableOfCustomerArrival());
    }

    private void buildTableDataOfTime(String ultColTitle, TableView<RowDataProcessed> table) {
        TableColumn<RowDataProcessed, Double> colProbability =
                column("Probabilidad", "probability", 100);
        TableColumn<RowDataProcessed, Double> colAccumulated =
                column("Distribucion\nAcumulada", "accumulatedDistribution", 100);
        TableColumn<RowDataProcessed, String> colRange =
                column("Rango de\n#s aleatorios", "range", 120);
        TableColumn<RowDataProcessed, Integer> colData =
                column(ultColTitle, "data", 100);
        table.getColumns().addAll(List.of(colProbability, colAccumulated, colRange, colData));
        table.setPrefWidth(420);
        table.setPrefHeight(150);
    }

    private void buildTableResult() {
        TableColumn<RowResult, Integer> colClient =
                column("client", "client", 80);

        TableColumn<RowResult, Double> colRandomNumberOne =
                column("#aleatorio", "randomNumberOne", 100);

        TableColumn<RowResult, Integer> colIntervalArrival =
                column("Intervalo\nLlegada", "intervalArrival", 100);

        TableColumn<RowResult, String> colTimeArrival =
                column("hora de\nllegada", "timeArrival", 100);

        TableColumn<RowResult, Double> colRandomNumberTwo =
                column("#aleatorio", "randomNumberTwo", 100);

        TableColumn<RowResult, Integer> colTService =
                column("t servicio", "timeOfService", 100);

        TableColumn<RowResult, String> colStartService =
                column("Inicio de\nServicio", "startService", 100);

        TableColumn<RowResult, String> colEndService =
                column("fin de\nservicio", "endService", 100);

        TableColumn<RowResult, Integer> colTimeWait =
                column("Tiempo de\nespera", "timeWait", 100);

        TableColumn<RowResult, Integer> colTimeLeisure =
                column("Tiempo de\nocio", "timeLeisure", 100);

        tableResult.getColumns().addAll(List.of(colClient, colRandomNumberOne, colIntervalArrival,
                colTimeArrival, colRandomNumberTwo, colTService, colStartService, colEndService,
                colTimeWait, colTimeLeisure));
        tableResult.setPrefHeight(200);
    }
}
