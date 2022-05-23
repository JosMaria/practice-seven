package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practiceseven.service.ExerciseSix;
import org.genesiscode.practiceseven.service.utils.Util;
import org.genesiscode.practiceseven.view.row.five.RowInputData;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;
import org.genesiscode.practiceseven.view.row.six.RowResult;

import java.util.List;

public class ExerciseSixPane extends MyPane {

    private static ExerciseSixPane exerciseSixPane;
    private final ExerciseSix exerciseSix;
    private TableView<RowInputData> demandTable, deliveryTimeTable;
    private TableView<RowDataProcessed> dataToDemandTable, dataToDeliveryTimeTable;
    private TableView<RowResult> resultTable;
    private Button btnStart;

    public ExerciseSixPane() {
        super("EJERCICIO 6");
        exerciseSix = new ExerciseSix();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseSixPane getInstance() {
        return exerciseSixPane == null ? new ExerciseSixPane() : exerciseSixPane;
    }

    public void loadControls() {
        buildTableRandomNumbers();
        btnAdd.setOnAction(actionEvent -> click_btn_add());

        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_btn_start());

        demandTable = new TableView<>();
        deliveryTimeTable = new TableView<>();
        buildInputTable(demandTable, "Demanda por\nSemana", 160);
        buildInputTable(deliveryTimeTable, "Tiempo de\nEntrega", 120);
        demandTable.setItems(exerciseSix.getListToDemandTable());
        deliveryTimeTable.setItems(exerciseSix.getListToDeliveryTimeTable());

        dataToDemandTable = buildDataProcessedTable("Demanda");
        dataToDeliveryTimeTable = buildDataProcessedTable("Tiempo de\nEntrega");

        resultTable = buildResultTable();
    }

    private TableView<RowResult> buildResultTable() {
        TableView<RowResult> table = new TableView<>();
        table.getColumns().addAll(List.of(
                column("#Semana", "week", 80),
                column("Unidades\nRecibidas", "unitsReceived", 80),
                column("Inventario\nInicial", "initialInventory", 80),
                column("#Aleatorio", "numberRandomOne", 90),
                column("Demanda", "demand", 80),
                column("Inventario\nFinal", "finalInventory", 80),
                column( "Ventas\nPerdidas", "lostSales", 80),
                column("ORDENAR", "sort", 80),
                column("#Aleatorio", "numberRandomTwo", 90),
                column("Tiempo\nEntrega", "deliveryTime", 80)));
        table.setPrefWidth(820);
        table.setMaxHeight(240);
        return table;
    }

    private void click_btn_start() {
        dataToDeliveryTimeTable.setItems(exerciseSix.loadListToDeliveryTimeTable());
        dataToDemandTable.setItems(exerciseSix.loadListToDemandTable());
        ExerciseSixPaneAssist.show(dataToDemandTable, dataToDeliveryTimeTable, resultTable);
    }

    private void buildInputTable(TableView<RowInputData> table, String titleToColOne, double height) {
        TableColumn<RowInputData, Integer> colDemand =
                column(titleToColOne, "numberOfPrograms", 110);
        TableColumn<RowInputData, Double> colDeliveryTime =
                column("Probabilidad", "probability", 105);
        table.getColumns().addAll(List.of(colDemand, colDeliveryTime));
        table.setPrefWidth(230);
        table.setMaxHeight(height);
    }

    private void click_btn_add() {
        tableRandomNumbers.setItems(exerciseSix.loadRandomNumbers(Util.convertToList(txtRandomNumbers.getText())));
    }

    public void buildPane() {
        VBox randomNumbersPane = new VBox(10, inputPane, tableRandomNumbers, btnStart);
        randomNumbersPane.setAlignment(Pos.CENTER);
        randomNumbersPane.setFillWidth(false);

        VBox inputPane = new VBox(20, demandTable, deliveryTimeTable);
        inputPane.setAlignment(Pos.CENTER);
        inputPane.setFillWidth(false);

        HBox pane = new HBox(20, randomNumbersPane, inputPane);
        pane.setAlignment(Pos.CENTER);
        mainPane = new VBox(10, title, pane);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(10));
    }
}
