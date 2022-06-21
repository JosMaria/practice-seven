package org.genesiscode.practiceseven.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {

    public static void show() {
        Stage stage = new Stage();
        String msgTotal = """
                    Los datos no cumplen el
                    formato correcto para
                    comenzar el proceso
                """;
        VBox main = new VBox(new Label(msgTotal));

        main.setPadding(new Insets(30));
        stage.setScene(new Scene(main));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Error");
        stage.showAndWait();
    }
}
