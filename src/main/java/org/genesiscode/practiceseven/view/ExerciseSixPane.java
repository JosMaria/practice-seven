package org.genesiscode.practiceseven.view;

import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import org.genesiscode.practiceseven.service.ExerciseSix;
import org.genesiscode.practiceseven.service.utils.Util;
import org.genesiscode.practiceseven.view.row.four.RowRandomNumbers;

public class ExerciseSixPane extends MyPane {

    private static ExerciseSixPane exerciseSixPane;
    private final ExerciseSix exerciseSix;
    private TableView<RowRandomNumbers> randomNumbersTable;

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
    }

    private void click_btn_add() {
        tableRandomNumbers.setItems(exerciseSix.loadRandomNumbers(Util.convertToList(txtRandomNumbers.getText())));
    }

    public void buildPane() {
        VBox randomNumbersPane = new VBox(10, inputPane, tableRandomNumbers);
        randomNumbersPane.setAlignment(Pos.CENTER);

        randomNumbersPane.setFillWidth(false);
        mainPane = new VBox(10, title, randomNumbersPane);
    }
}
