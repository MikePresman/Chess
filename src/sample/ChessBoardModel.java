package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

enum ChessPiece{
    BLACK_PAWN, BLACK_ROOK, BLACK_KNIGHT, BLACK_QUEEN, BLACK_KING, BLACK_BISHOP,

    WHITE_PAWN, WHITE_ROOK, WHITE_KNIGHT, WHITE_QUEEN, WHITE_KING, WHITE_BISHOP,

    NONE
}


public class ChessBoardModel {
    private final double CHESS_BOARD_HEIGHT = 600;
    private final double CHESS_BOARD_WIDTH = 600;

    Rectangle[] brownTiles = new Rectangle[32];
    private Rectangle[] grayTiles = new Rectangle[32];

    private Pane canvas;

    private ChessPiece[][] chessBoardLayout = {
                                                {ChessPiece.BLACK_ROOK, ChessPiece.BLACK_KNIGHT, ChessPiece.BLACK_BISHOP, ChessPiece.BLACK_QUEEN, ChessPiece.BLACK_KING, ChessPiece.BLACK_BISHOP, ChessPiece.BLACK_KNIGHT, ChessPiece.BLACK_ROOK},
                                                {ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN},
                                                {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
                                                {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
                                                {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
                                                {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
                                                {ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN},
                                                {ChessPiece.WHITE_ROOK, ChessPiece.WHITE_KNIGHT, ChessPiece.WHITE_BISHOP, ChessPiece.WHITE_QUEEN, ChessPiece.WHITE_KING, ChessPiece.WHITE_BISHOP, ChessPiece.WHITE_KNIGHT, ChessPiece.WHITE_ROOK}
                                            };


    public ChessBoardModel(Pane canvas) {
        drawBoard(canvas);
    }


    public void drawPiecesOnBoard() {
        for (int row = 0; row < 8; row++) {
            for (int tile = 0; tile < 8; tile++) {
                if (chessBoardLayout[row][tile] == ChessPiece.NONE){
                    continue;
                }

                String imageName = "src/assets/" + chessBoardLayout[row][tile] + ".png";
                ImageView imageView;



                try{
                    FileInputStream input = new FileInputStream(imageName);
                    Image image = new Image(input);
                    imageView = new ImageView(image);
                }catch (FileNotFoundException e){
                    System.out.println("Chess Piece not Found to Draw" + imageName.toString()); //should use logging later
                    return;
                }

                double currentTileX = tile * 600/8; //current tile spot, starting at 0
                imageView.setX(currentTileX + (24 / 2));

                double currentTileY = row * 600 /8;
                imageView.setY(currentTileY + (24/2));

                this.canvas.getChildren().add(imageView);

            }
        }
    }

    public Pane getCanvas(){
        return this.canvas;
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

        this.canvas = canvas;
    }


    public void reDrawBoard(){

    }

    public void getBoard(){

    }
}


