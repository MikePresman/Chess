package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        ChessBoardModel game = new ChessBoardModel(canvas);
        game.drawPiecesOnBoard();





        //setting the init scene - can not resize the stage
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(canvas, 600, 600));
        primaryStage.show();

        //create a button + or - to resize

        while(Game.gameOver != false){
            //ask player to make their next move
            //calculate logic based on the move
            //redraw
            //continue
            break;
        }
    }
}