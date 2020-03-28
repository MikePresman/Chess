package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chess");

        //init chessboard drawing
        Pane canvas = new Pane();
        double paneHeight = 1000;
        double paneWidth = 1000;
        ChessBoardModel newGame = new ChessBoardModel();
        newGame.drawBoard(canvas, paneHeight, paneWidth);

        //setting the init scene
        primaryStage.setScene(new Scene(canvas, 1000, 1000));
        primaryStage.show();



        //Listener for window width resize
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            newGame.drawBoard(canvas, paneHeight, (double) newVal);

        });




        //Listener for window height resize
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            newGame.drawBoard(canvas, (double) newVal, paneWidth);

        });



        while(Game.gameOver != false){
            //ask player to make their next move
            //calculate logic based on the move
            //redraw
            //continue
            break;
        }
    }
}

