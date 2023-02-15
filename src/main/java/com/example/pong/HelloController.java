package com.example.pong;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    @FXML
    private Rectangle racquet1, racquet2;
    @FXML
    private Circle ball;

    @FXML
    public void initialize() {

        ball.sceneProperty().addListener((observableValue, scene, t1) -> t1.setOnKeyPressed(keyEvent ->
        {

            if (keyEvent.getCode() == KeyCode.UP) {
                racquet2.setY(racquet2.getY() - 10);
            } else if (keyEvent.getCode() == KeyCode.DOWN) {
                racquet2.setY(racquet2.getY() + 10);
            } else if (keyEvent.getCode() == KeyCode.W) {
                racquet1.setY(racquet1.getY() - 10);
            } else if (keyEvent.getCode() == KeyCode.S) {
                racquet1.setY(racquet1.getY() + 10);
            }
        }));

    }
}
