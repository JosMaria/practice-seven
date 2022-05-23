package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;

public class ExerciseSixPaneAssist {

    public static void show(TableView<RowDataProcessed> tableOne, TableView<RowDataProcessed> tableTwo) {
        Stage stage = new Stage(StageStyle.DECORATED);
        HBox pane = new HBox(10, tableOne, tableTwo);
        pane.setPadding(new Insets(10));
        pane.setFillHeight(false);

        stage.setScene(new Scene(pane));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");
        stage.showAndWait();
    }
}
