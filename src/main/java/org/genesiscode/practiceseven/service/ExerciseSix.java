package org.genesiscode.practiceseven.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceseven.service.utils.Util;
import org.genesiscode.practiceseven.view.row.five.RowInputData;
import org.genesiscode.practiceseven.view.row.four.RowDataProcessed;
import org.genesiscode.practiceseven.view.row.six.RowResult;

import java.util.Iterator;
import java.util.List;

public class ExerciseSix extends Exercise {

    private ObservableList<RowInputData> listToDemandTable, listToDeliveryTimeTable;
    private ObservableList<RowDataProcessed> observableListToDemandTable, observableListToDeliveryTimeTable;
    private int finalInventoryTotal, lostSalesTotal;


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

    public ObservableList<RowResult> loadResult(int unitsReceivedGiven, int initialInventory, int orderOfRefrigerators) {
        ObservableList<RowResult> list = FXCollections.observableArrayList();

        boolean alreadyPrint = false;
        int week = 1, lostSales, finalInventory, demand, deliveryTime = 0, unitsReceived = 0;
        double randomNumberOne, randomNumberTwo = 0;
        String sort = "";

        Iterator<Double> iterator = randomNumbers.iterator();
        while (iterator.hasNext()) {
            randomNumberOne = iterator.next();
            demand = givenData(randomNumberOne, observableListToDemandTable);

            finalInventory = initialInventory - demand;
            if (finalInventory < 0) {
                lostSales = Math.abs(finalInventory);
                finalInventory = 0;
            } else {
                lostSales = 0;
            }

            if (! alreadyPrint && finalInventory <= orderOfRefrigerators && lostSales == 0) {
                alreadyPrint = true;
                sort = "SI";
                randomNumberTwo = iterator.next();
                deliveryTime = givenData(randomNumberTwo, observableListToDeliveryTimeTable);
            }

            RowResult row = new RowResult(week, valueToZero(unitsReceived), initialInventory, randomNumberOne,
                    demand, finalInventory, lostSales, sort, valueToZero(randomNumberTwo), valueToZero(deliveryTime));
            list.add(row);

            unitsReceived = lostSales > 0 ? unitsReceivedGiven : 0;

            if (unitsReceived == unitsReceivedGiven) {
                initialInventory = unitsReceived;
                alreadyPrint = false;
            } else {
                initialInventory = finalInventory;
            }

            sort = "";
            randomNumberTwo = 0;
            deliveryTime = 0;
            week++;
        }

        finalInventoryTotal = getFinalInventoryTotal(list);
        lostSalesTotal = getLostSalesTotal(list);
        return list;
    }

    private int getLostSalesTotal(ObservableList<RowResult> list) {
        List<Integer> numbers = list.stream()
                .map(RowResult::getLostSales)
                .toList();

        int total = 0;
        for (Integer number : numbers) {
            total += number;
        }
        return total;
    }

    private int getFinalInventoryTotal(ObservableList<RowResult> list) {
        List<Integer> numbers = list.stream()
                .map(RowResult::getFinalInventory)
                .toList();

        int total = 0;
        for (Integer number : numbers) {
            total += number;
        }
        return total;
    }

    private String valueToZero(double number) {
        return number == 0 ? "" : String.valueOf(number);
    }

    private int givenData(double randomNumberOne, ObservableList<RowDataProcessed> list) {
        return list.stream()
                .filter(row -> row.getStartRange() <= randomNumberOne && randomNumberOne < row.getEndRange())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Doesn't exists"))
                .getData();
    }

    public ObservableList<RowDataProcessed> loadListToDemandTable() {
        observableListToDemandTable = Util.listOfIntervals(listToDemandTable);
        return observableListToDemandTable;
    }

    public ObservableList<RowDataProcessed> loadListToDeliveryTimeTable() {
        observableListToDeliveryTimeTable = Util.listOfIntervals(listToDeliveryTimeTable);
        return observableListToDeliveryTimeTable;
    }

    public ObservableList<RowInputData> getListToDemandTable() {
        return listToDemandTable;
    }

    public ObservableList<RowInputData> getListToDeliveryTimeTable() {
        return listToDeliveryTimeTable;
    }

    public int getFinalInventoryTotal() {
        return finalInventoryTotal;
    }

    public int getLostSalesTotal() {
        return lostSalesTotal;
    }
}
