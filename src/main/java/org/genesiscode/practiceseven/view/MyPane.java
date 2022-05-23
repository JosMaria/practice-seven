package org.genesiscode.practiceseven.view;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.genesiscode.practiceseven.view.row.four.RowRandomNumbers;

import java.util.List;

public class MyPane {

    protected VBox mainPane;
    protected Label title;
    protected TableView<RowRandomNumbers> tableRandomNumbers;
    protected TextField txtRandomNumbers;
    protected Button btnAdd;
    protected VBox inputPane;

    protected MyPane(String titleHeader) {
        title = new Label(titleHeader);
        title.setFont(new Font("Gargi", 20));
        tableRandomNumbers = new TableView<>();

        txtRandomNumbers = new TextField();
        txtRandomNumbers.setPrefColumnCount(20);
        btnAdd = new Button("Agregar");
        inputPane = new VBox(10, new Label("Numeros Aleatorios"), txtRandomNumbers, btnAdd);
    }

    protected void buildTableRandomNumbers() {
        TableColumn<RowRandomNumbers, Integer> colRow = column("Fila", "data", 50);
        TableColumn<RowRandomNumbers, Double> colRandomNumbers = column("Numeros\nAletorios", "value", 120);
        tableRandomNumbers.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableRandomNumbers.setPrefWidth(150);
        tableRandomNumbers.setPrefHeight(300);
    }

    protected <U, T> TableColumn<U, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<U, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
