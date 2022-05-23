package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;

public class ExerciseFivePaneAssist {

    public static void show(TableView<RowDataProcessed> table) {
        Stage stage = new Stage(StageStyle.DECORATED);

        VBox pane = new VBox(table);
        pane.setPadding(new Insets(10));
        stage.setScene(new Scene(pane));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");
        stage.showAndWait();
    }
}
