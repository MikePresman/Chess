package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoardModel {
    private final double CHESS_BOARD_HEIGHT = 600;
    private final double CHESS_BOARD_WIDTH = 600;

    Rectangle[] brownTiles = new Rectangle[32];
    private Rectangle[] grayTiles = new Rectangle[32];

    public ChessBoardModel() {

    }




    public void drawBoard(Pane canvas) {
        double tileWidth = CHESS_BOARD_WIDTH / 8;
        double tileHeight = CHESS_BOARD_HEIGHT / 8;

        int tileXPosition = 0;
        int tileYPosition = 0;
        int row = 1;

        //add of the tiles into an array with their respective coordinates, then display add them in canvas
        for (int tile = 0; tile < 32; tile++) {
            if (row % 2 == 0) {
                Rectangle brownTile = new Rectangle(tileXPosition, tileYPosition, tileWidth, tileHeight);
                brownTile.setFill(Color.GRAY);
                brownTiles[tile] = brownTile;
                tileXPosition += tileWidth;
                Rectangle grayTile = new Rectangle(tileXPosition, tileYPosition, tileWidth, tileHeight);
                grayTile.setFill(Color.WHITE);
                grayTiles[tile] = grayTile;
                tileXPosition += tileWidth;

            } else {
                Rectangle grayTile = new Rectangle(tileXPosition, tileYPosition, tileWidth, tileHeight);
                grayTile.setFill(Color.WHITE);
                grayTiles[tile] = grayTile;
                tileXPosition += tileWidth;

                Rectangle brownTile = new Rectangle(tileXPosition, tileYPosition, tileWidth, tileHeight);
                brownTile.setFill(Color.GRAY);
                brownTiles[tile] = brownTile;
                tileXPosition += tileWidth;
            }

            if ((tile + 1) % 4 == 0 && tile > 0) {
                tileYPosition += tileHeight;
                tileXPosition = 0;
                row++;
            }
        }

        for (Rectangle r : brownTiles){
            canvas.getChildren().add(r);
        }

        for (Rectangle r: grayTiles){
            canvas.getChildren().add(r);
        }
    }


    public void reDrawBoard(){

    }

    public void getBoard(){

    }
}


