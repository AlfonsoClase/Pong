package com.example.pong;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    private Rectangle Racquet1, Racquet2;
    private Circle ball;

    private Pane panel;




   public void initialize(){

       ball.getScene().setOnKeyPressed(keyEvent ->
       {
           if (keyEvent.getCode() == KeyCode.UP){
               Racquet2.setY(Racquet2.getY() - 10);
           } else if (keyEvent.getCode() == KeyCode.DOWN)
           {
               Racquet2.setY(Racquet2.getY() + 10);
           } else if (keyEvent.getCode() == KeyCode.W)
           {
               Racquet1.setY(Racquet1.getY() - 10);
           } else if (keyEvent.getCode() == KeyCode.S)
           {
               Racquet1.setY(Racquet1.getY() + 10);
           }
       });

   }
}