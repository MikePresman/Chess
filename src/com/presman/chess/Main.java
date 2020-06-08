package com.presman.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //init chessboard drawing
        Pane canvas = new Pane();
        GameController gameController = new GameController(canvas);

        //setting the init scene - can not resize the stage
        Scene scene = new Scene(canvas,600, 600);
        primaryStage.setTitle("Chess");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


        //Event-driven responses
        scene.setOnMouseClicked(event -> {
            gameController.handleEvent(event);
        });
        }





    }


