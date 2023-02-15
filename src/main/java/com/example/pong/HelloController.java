package com.example.pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Rectangle racquet1, racquet2;
    @FXML
    private Circle ball;

    private int centro = 0;

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

        Timeline animationBall = new Timeline(
                new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                    ball.setCenterX(centro);
                    centro++;
                })
        );
        animationBall.setCycleCount(Timeline.INDEFINITE);
        animationBall.play();

    }
}
