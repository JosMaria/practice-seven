package org.genesiscode.practiceseven.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceseven.service.utils.Decimal;
import org.genesiscode.practiceseven.view.row.five.RowInputData;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;
import org.genesiscode.practiceseven.view.row.four.RowRandomNumbers;

import java.util.List;

public class ExerciseFive {

    private ObservableList<RowInputData> listToTableInputData;
    private List<Double> randomNumbers;

    public ExerciseFive() {
        load();
    }

    private void load() {
        List<RowInputData> listToTableInputData = List.of(
                new RowInputData(2300, 0.15),
                new RowInputData(2400, 0.22),
                new RowInputData(2500, 0.24),
                new RowInputData(2600, 0.21),
                new RowInputData(2700, 0.18));
        this.listToTableInputData = FXCollections.observableList(listToTableInputData);
    }

    public ObservableList<RowInputData> getListToTableInputData() {
        return listToTableInputData;
    }

    public ObservableList<RowRandomNumbers> loadRandomNumber(List<Double> randomNumbers) {
        this.randomNumbers = randomNumbers;
        ObservableList<RowRandomNumbers> randomNumbersRandom = FXCollections.observableArrayList();
        int counter = 1;
        for (double randomNumber : this.randomNumbers) {
            randomNumbersRandom.add(new RowRandomNumbers(counter, randomNumber));
            counter++;
        }
        return randomNumbersRandom;
    }

    public ObservableList<RowDataProcessed> listOfIntervals() {
        ObservableList<RowDataProcessed> list = FXCollections.observableArrayList();
        double accumulated = 0, startRange, endRange;
        for (RowInputData row : listToTableInputData) {
            double probability = row.getProbability();
            startRange = accumulated;
            accumulated += probability;
            accumulated = Decimal.getDecimal(2, accumulated);
            endRange = accumulated;

            RowDataProcessed rowToAdd = new RowDataProcessed(probability, accumulated,
                    String.format("[%s - %s)", startRange, endRange), row.getNumberOfPrograms());
            rowToAdd.setStartRange(startRange);
            rowToAdd.setEndRange(endRange);
            list.add(rowToAdd);
        }
        return list;
    }
}
