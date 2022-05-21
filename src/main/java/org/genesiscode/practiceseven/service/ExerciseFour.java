package org.genesiscode.practiceseven.service;

import javafx.collections.ObservableList;
import org.genesiscode.practiceseven.view.row.four.RowInputData;

import java.util.List;

public class ExerciseFour {

    private List<Double> randomNumbers;
    private ObservableList<RowInputData> listToTableOfTime, listToTableOfCustomerArrival;

    public ExerciseFour() {
        load();
    }

    private void load() {
        List.of(new RowInputData(0, 0.00),
                new RowInputData(0, 0.00),
                new RowInputData(0, 0.00),
                new RowInputData(0, 0.00),
                new RowInputData(0, 0.00));

    }
}
