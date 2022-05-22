package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;
import org.genesiscode.practiceseven.view.row.four.RowResult;

public class ExerciseFourPaneAssist {

    public static void show(TableView<RowDataProcessed> tableOne, TableView<RowDataProcessed> tableTwo,
                            TableView<RowResult> tableResult) {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");

        HBox topPane = new HBox(20, tableOne, tableTwo);
        topPane.setAlignment(Pos.CENTER);
        VBox pane = new VBox(10, topPane, tableResult);
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
