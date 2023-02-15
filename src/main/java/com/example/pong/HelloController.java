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
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Rectangle racquet1, racquet2;
    @FXML
    private Circle ball;

    private int centro = 0;
    private int velBola = 2;

    @FXML
    public void initialize() {


        ball.sceneProperty().addListener((observableValue, scene, t1) -> t1.setOnKeyPressed(keyEvent ->
        {
            //Bordes de las palas
            if (racquet1.getY() < -100 ){
                racquet1.setY(-100);
            } else if (racquet1.getY() > 160) {
                racquet1.setY(160);
            } else if (racquet2.getY() < -100 ){
                racquet2.setY(-100);
            } else if (racquet2.getY() > 160) {
                racquet2.setY(160);
            }

            //Controles pala
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



        //Animacion bola
        Timeline animationBall = new Timeline(
                new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                    ball.setCenterX(centro);
                    Shape colisionI = Shape.intersect(ball, racquet1);
                    Shape colisionD = Shape.intersect(ball,racquet2);
                    boolean colisionIzquierda = colisionI.getBoundsInLocal().isEmpty();
                    boolean colisionDerecha = colisionD.getBoundsInLocal().isEmpty();

                    if (colisionIzquierda == false){
                        velBola = 3;
                    } else if (colisionDerecha == false){
                        velBola = -3;
                    }
                    centro += velBola;
                })
        );
        animationBall.setCycleCount(Timeline.INDEFINITE);
        animationBall.play();

    }
}
