package org.genesiscode.practiceseven.view;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MyPane {

    protected VBox mainPane;
    protected Label title;

    protected MyPane(String titleHeader) {
        title = new Label(titleHeader);
        title.setFont(new Font("Gargi", 20));
    }

    protected VBox getMainPane() {
        return mainPane;
    }

    protected <U, T> TableColumn<U, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<U, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
