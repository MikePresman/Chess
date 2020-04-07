package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;


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
        ChessBoardModel chessBoard = new ChessBoardModel(canvas);
        chessBoard.drawPiecesOnBoard();
        canvas = chessBoard.getCanvas(); //unecessary since canvas is a reference type, but this is more explicit hence i like it

        //setting the init scene - can not resize the stage
        Scene scene = new Scene(canvas,600, 600);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();




        //get mouse click for current player to see which piece they've chosen
        scene.setOnMouseClicked(event -> {
            chessBoard.getSelectedPiece(event);
        });








        //check if move is valid
        //update canvas
        //see if game is over
        //get next players move repeat



        }
    }


