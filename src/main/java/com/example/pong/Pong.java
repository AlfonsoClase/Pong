package com.example.pong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Pong extends Application {

    @Override
    public void start(Stage primaryStage){

        FXMLLoader loader = new FXMLLoader();

        primaryStage.setTitle("Pong Juego");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}