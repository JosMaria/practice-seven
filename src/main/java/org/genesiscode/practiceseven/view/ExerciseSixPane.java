package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
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
    private TextField fieldUnitsReceivedGiven, fieldInitialInventory, fieldOrderOfRefrigerators;

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
        fieldUnitsReceivedGiven = new TextField();
        fieldUnitsReceivedGiven.setPrefColumnCount(5);
        fieldInitialInventory = new TextField();
        fieldInitialInventory.setPrefColumnCount(5);
        fieldOrderOfRefrigerators = new TextField();
        fieldOrderOfRefrigerators.setPrefColumnCount(5);

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

    private VBox buildInputPane() {
        HBox paneOne = new HBox(10, new Label("Unidades Recibidas"), fieldUnitsReceivedGiven);
        paneOne.setAlignment(Pos.CENTER_RIGHT);
        HBox paneTwo = new HBox(10, new Label("Inventario Inicial"), fieldInitialInventory);
        paneTwo.setAlignment(Pos.CENTER_RIGHT);
        HBox paneThree = new HBox(10, new Label("Orden refrigeradores"), fieldOrderOfRefrigerators);
        paneThree.setAlignment(Pos.CENTER_RIGHT);

        VBox pane = new VBox(10, paneOne, paneTwo, paneThree);
        pane.setAlignment(Pos.CENTER);
        return pane;
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
        table.setMaxHeight(260);
        return table;
    }

    private void click_btn_start() {
        dataToDeliveryTimeTable.setItems(exerciseSix.loadListToDeliveryTimeTable());
        dataToDemandTable.setItems(exerciseSix.loadListToDemandTable());

        try {
            int unitsReceivedGiven = Integer.parseInt(fieldUnitsReceivedGiven.getText());
            int initialInventory = Integer.parseInt(fieldInitialInventory.getText());
            int orderOfRefrigerators = Integer.parseInt(fieldOrderOfRefrigerators.getText());
            resultTable.setItems(exerciseSix.loadResult(unitsReceivedGiven, initialInventory, orderOfRefrigerators));
            ExerciseSixPaneAssist.show(dataToDemandTable, dataToDeliveryTimeTable, resultTable,
                    exerciseSix.getFinalInventoryTotal(), exerciseSix.getLostSalesTotal());
        } catch (Exception e) {
            MessageBox.show();
        }
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

        VBox rightPane = new VBox(30, buildInputPane(), inputPane);
        rightPane.setAlignment(Pos.CENTER);

        HBox pane = new HBox(20, randomNumbersPane, rightPane);
        pane.setAlignment(Pos.CENTER);
        mainPane = new VBox(10, title, pane);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(10));
    }
}
