package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;
import org.genesiscode.practiceseven.view.row.six.RowResult;

public class ExerciseSixPaneAssist {

    public static void show(TableView<RowDataProcessed> tableOne, TableView<RowDataProcessed> tableTwo,
                            TableView<RowResult> table, int inventoryFinalTotal, int lostSalesTotal) {
        Stage stage = new Stage(StageStyle.DECORATED);
        HBox pane = new HBox(10, tableOne, tableTwo);
        pane.setFillHeight(false);

        String msgTotal = "TOTAL:\tInventario Final = %s\tVentas perdidas = %s";
        VBox main = new VBox(20, pane, table, new Label(String.format(msgTotal, inventoryFinalTotal, lostSalesTotal)));
        main.setAlignment(Pos.CENTER);
        main.setPadding(new Insets(20));

        stage.setScene(new Scene(main));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");
        stage.showAndWait();
    }
}
