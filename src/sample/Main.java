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
        canvas = game.getCanvas();


        /*
        FileInputStream input = new FileInputStream("src/assets/BLACK_BISHOP.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        double currentTileX = 2 * 600/8; //current tile spot, starting at 0
        imageView.setX(currentTileX + (24 / 2));


        double currentTileY = 0 * 600 /8;
        imageView.setY(currentTileY + (24/2));
        canvas.getChildren().add(imageView);
        */







        //setting the init scene - can not resize the stage
        primaryStage.setResizable(true);
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