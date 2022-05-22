package org.genesiscode.practiceseven.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceseven.service.utils.Decimal;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;
import org.genesiscode.practiceseven.view.row.four.RowInputData;
import org.genesiscode.practiceseven.view.row.four.RowResult;

import java.time.LocalTime;
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

    public ObservableList<RowInputData> getList(List<Double> randomNumbers) {
        this.randomNumbers = randomNumbers;
        ObservableList<RowInputData> list = FXCollections.observableArrayList();
        int counter = 1;
        for (Double randomNumber : this.randomNumbers) {
            list.add(new RowInputData(counter, randomNumber));
            counter++;
        }
        return list;
    }

    public ObservableList<RowDataProcessed> getListToTableOf(ObservableList<RowInputData> listToTableOfTime) {
        ObservableList<RowDataProcessed> list = FXCollections.observableArrayList();
        double accumulated = 0.0;
        for (RowInputData row : listToTableOfTime) {
            if (row.getValue() != 0.0) {
                double probability = row.getValue();
                double startRange = accumulated;
                accumulated += probability;
                accumulated = Decimal.getDecimal(2, accumulated);
                double endRange = accumulated;
                String range = String.format("[%s - %s)", startRange, endRange);

                RowDataProcessed rowDataProcessed = new RowDataProcessed(probability, accumulated, range, row.getData());
                list.add(rowDataProcessed);
                rowDataProcessed.setStartRange(startRange);
                rowDataProcessed.setEndRange(endRange);
            }
        }
        return list;
    }

    public ObservableList<RowResult> getListResult(ObservableList<RowDataProcessed> tableDataOfTime,
                                                   ObservableList<RowDataProcessed> tableDataOfCustomerArrival) {
        ObservableList<RowResult> list = FXCollections.observableArrayList();
        LocalTime timeOfArrival = LocalTime.of(9, 0), startService, endService = null;
        for (int i = 0, client = 1; i < randomNumbers.size(); i++, client++) {
            double randomNumberOne = randomNumbers.get(i);  // print 2
            i++;
            int intervalBetweenArrival = getValueGivenInterval(randomNumberOne, tableDataOfCustomerArrival); // print 3
            timeOfArrival = timeOfArrival.plusMinutes(intervalBetweenArrival);
            double randomNumberTwo = randomNumbers.get(i);
            int tService = getValueGivenInterval(randomNumberTwo, tableDataOfTime);
            startService = endService == null ? timeOfArrival : endService;
            int timeOfLeisure = endService == null ? intervalBetweenArrival : endService.getMinute() - startService.getMinute();
            endService = startService.plusMinutes(tService);
            int timeOfWait = startService.getMinute() - timeOfArrival.getMinute();

            RowResult rowResult = new RowResult(client, randomNumberOne, intervalBetweenArrival,
                    timeOfArrival.toString(), randomNumberTwo, tService, startService.toString(),
                    endService.toString(), timeOfWait, timeOfLeisure);
            list.add(rowResult);
        }
        return list;
    }

    private int getValueGivenInterval(double randomNumber, ObservableList<RowDataProcessed> list) {
        return list.stream()
                .filter(row -> row.getStartRange() <= randomNumber && randomNumber < row.getEndRange())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Doesn't exists interval"))
                .getData();
    }
}
