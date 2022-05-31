package org.genesiscode.practiceseven.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceseven.view.row.four.RowRandomNumbers;

import java.util.List;

public class Exercise {

    protected List<Double> randomNumbers;

    public ObservableList<RowRandomNumbers> loadRandomNumbers(List<Double> randomNumbers) {
        this.randomNumbers = randomNumbers;
        ObservableList<RowRandomNumbers> list = FXCollections.observableArrayList();
        int counter = 1;
        for (double randomNumber : this.randomNumbers) {
            list.add(new RowRandomNumbers(counter, randomNumber));
            counter++;
        }
        return list;
    }
}
