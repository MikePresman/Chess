package com.presman.chess;

import com.presman.chess.ChessBoardHandler.GameController;
import com.presman.chess.Communication.Client;
import com.presman.chess.Communication.Server;
import com.presman.chess.Misc.ConfigReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


public class Main extends Application {
    public static HashMap<String, String> configProperties = new HashMap<>();
    public static Server server;
    public static Client client;
    public static boolean singlePlayer = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //get config
        ConfigReader.getConfigDetails();
        determineGameMode();

        //init chessboard drawing
        Pane canvas = new Pane();
        GameController gameController = new GameController(canvas);


        //setting the init scene - can not resize the stage
        Scene scene = new Scene(canvas, 600, 600);
        if (configProperties.get("HOST?").equals("true"))
            primaryStage.setTitle("Chess : HOST");
        else
            primaryStage.setTitle("Chess : Client");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        //make it run based on config file
        //setup ServerSocket


        //Event-driven responses
        scene.setOnMouseClicked(event -> {
            gameController.handleEvent(event);
        });
    }


    public void determineGameMode() {
        if (configProperties.get("SINGLE_PLAYER").equals("true")) {
            singlePlayer = true;
            return;
        } else if (configProperties.get("HOST?").equals("true")) {
                Main.server = new Server();
            } else {
                Main.client = new Client();
            }
        }
    }

