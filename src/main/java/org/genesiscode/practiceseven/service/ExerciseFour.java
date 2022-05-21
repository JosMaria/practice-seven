package org.genesiscode.practiceseven.service;

import javafx.collections.FXCollections;
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
        List<RowInputData> listToTableOfTime = List.of(new RowInputData(0, 0.00),
                new RowInputData(1, 0.25),
                new RowInputData(2, 0.20),
                new RowInputData(3, 0.40),
                new RowInputData(4, 0.15));
        this.listToTableOfTime = FXCollections.observableList(listToTableOfTime);

        List<RowInputData> listToTableOfCustomerArrival = List.of(
                new RowInputData(0, 0.10), new RowInputData(1, 0.35),
                new RowInputData(2, 0.25), new RowInputData(3, 0.15),
                new RowInputData(4, 0.10), new RowInputData(5, 0.05));
        this.listToTableOfCustomerArrival = FXCollections.observableList(listToTableOfCustomerArrival);
    }

    public ObservableList<RowInputData> getListToTableOfTime() {
        return listToTableOfTime;
    }

    public ObservableList<RowInputData> getListToTableOfCustomerArrival() {
        return listToTableOfCustomerArrival;
    }
}
