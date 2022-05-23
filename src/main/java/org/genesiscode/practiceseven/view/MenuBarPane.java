package org.genesiscode.practiceseven.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuBarPane implements EventHandler<ActionEvent> {

    private final VBox mainPane;
    private static final String EXERCISE_FOUR = "Ejercicio 4";
    private static final String EXERCISE_FIVE = "Ejercicio 5";
    private static final String EXERCISE_SIX = "Ejercicio 6";

    public MenuBarPane() {
        mainPane = new VBox(10, getMenuBar(), new VBox());
        mainPane.setPrefSize(650, 550);
    }

    public VBox getMainPane() {
        return mainPane;
    }

    private MenuBar getMenuBar() {
        Menu menuExerciseFour = new Menu(EXERCISE_FOUR);
        MenuItem menuItemFour = new MenuItem(EXERCISE_FOUR);
        menuExerciseFour.getItems().add(menuItemFour);
        menuItemFour.setOnAction(this);

        Menu menuExerciseFive = new Menu(EXERCISE_FIVE);
        MenuItem menuItemFive = new MenuItem(EXERCISE_FIVE);
        menuExerciseFive.getItems().add(menuItemFive);
        menuItemFive.setOnAction(this);

        Menu menuExerciseSix = new Menu(EXERCISE_SIX);
        MenuItem menuItemSix = new MenuItem(EXERCISE_SIX);
        menuExerciseSix.getItems().add(menuItemSix);
        menuItemSix.setOnAction(this);

        return new MenuBar(menuExerciseFour, menuExerciseFive, menuExerciseSix);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MenuItem source = (MenuItem) actionEvent.getSource();
        VBox pane = switch (source.getText()) {
            case EXERCISE_FOUR -> ExerciseFourPane.getInstance().mainPane;
            case EXERCISE_FIVE -> ExerciseFivePane.getInstance().mainPane;
            case EXERCISE_SIX -> ExerciseSixPane.getInstance().mainPane;
            default -> new VBox(new Label("Empty"));
        };

        changePane(pane);
    }

    private void changePane(Pane pane) {
        mainPane.getChildren().remove(1);
        mainPane.getChildren().add(pane);
    }
}
