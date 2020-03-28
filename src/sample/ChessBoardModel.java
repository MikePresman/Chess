package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoardModel {
    private double paneHeight = 1000;
    private double paneWidth = 1000;

    private Rectangle[] brownTiles = new Rectangle[32];
    private Rectangle[] grayTiles = new Rectangle[32];

    public ChessBoardModel() {

    }

    public void setPaneHeight(double height){
        this.paneHeight = height;
    }

    public void setPaneWidth(double width){
        this.paneWidth = width;
    }



    public void drawBoard(Pane canvas, double paneHeight, double paneWidth) {
        double tileWidth = paneWidth / 8;
        double tileHeight = paneHeight / 8;

        System.out.println(paneHeight);
        System.out.println(paneWidth);
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
                Rectangle grayTile = new Rectangle(tileXPosition, tileYPosition, 125, 125);
                grayTile.setFill(Color.WHITE);
                grayTiles[tile] = grayTile;
                tileXPosition += tileWidth;

            } else {
                Rectangle grayTile = new Rectangle(tileXPosition, tileYPosition, 125, 125);
                grayTile.setFill(Color.WHITE);
                grayTiles[tile] = grayTile;
                tileXPosition += tileWidth;

                Rectangle brownTile = new Rectangle(tileXPosition, tileYPosition, 125, 125);
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


