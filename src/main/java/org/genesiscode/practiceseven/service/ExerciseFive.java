package org.genesiscode.practiceseven.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceseven.view.row.five.RowInputData;

import java.util.List;

public class ExerciseFive {

    private ObservableList<RowInputData> listToTableInputData;

    public ExerciseFive() {
        load();
    }

    private void load() {
        List<RowInputData> listToTableInputData = List.of(new RowInputData(2300, 0.15),
                new RowInputData(2400, 0.22),
                new RowInputData(2500, 0.24),
                new RowInputData(2600, 0.21),
                new RowInputData(2700, 0.18));
        this.listToTableInputData = FXCollections.observableList(listToTableInputData);
    }

    public ObservableList<RowInputData> getListToTableInputData() {
        return listToTableInputData;
    }
}
