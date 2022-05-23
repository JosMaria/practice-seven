package org.genesiscode.practiceseven.service;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceseven.service.utils.Util;
import org.genesiscode.practiceseven.view.row.five.RowInputData;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;

import java.util.List;

public class ExerciseSix extends Exercise {

    private ObservableList<RowInputData> listToDemandTable, listToDeliveryTimeTable;

    public ExerciseSix() {
        load();
    }

    private void load() {
        listToDemandTable = FXCollections.observableList(List.of(
                new RowInputData(0, 0.20),
                new RowInputData(1, 0.40),
                new RowInputData(2, 0.20),
                new RowInputData(3, 0.15),
                new RowInputData(4, 0.05)));

        listToDeliveryTimeTable = FXCollections.observableList(List.of(
                new RowInputData(1, 0.15),
                new RowInputData(2, 0.35),
                new RowInputData(3, 0.50)));
    }

    public ObservableList<RowDataProcessed> loadListToDemandTable() {
        return Util.listOfIntervals(listToDemandTable);
    }

    public ObservableList<RowDataProcessed> loadListToDeliveryTimeTable() {
        return Util.listOfIntervals(listToDeliveryTimeTable);
    }

    public ObservableList<RowInputData> getListToDemandTable() {
        return listToDemandTable;
    }

    public ObservableList<RowInputData> getListToDeliveryTimeTable() {
        return listToDeliveryTimeTable;
    }
}
