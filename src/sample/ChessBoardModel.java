package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;

enum ChessPiece{
    BLACK_PAWN, BLACK_ROOK, BLACK_KNIGHT, BLACK_QUEEN, BLACK_KING, BLACK_BISHOP,

    WHITE_PAWN, WHITE_ROOK, WHITE_KNIGHT, WHITE_QUEEN, WHITE_KING, WHITE_BISHOP,

    NONE
}

public class ChessBoardModel {
    private final double CHESS_BOARD_HEIGHT = 600;
    private final double CHESS_BOARD_WIDTH = 600;

    private boolean pieceSelected = false;
    private int pieceSelectedX;
    private int pieceSelectedY;

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

                double currentTileX = tile * CHESS_BOARD_WIDTH / 8; //current tile spot, starting at 0
                imageView.setX(currentTileX + (24 / 2));

                double currentTileY = row * CHESS_BOARD_HEIGHT / 8;
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

    public void getSelectedPiece(MouseEvent m){
        if (!Game.gameRunning){
            return;
        }

        //if we already have a piece selected redraw board to get rid of the selected piece
        if (pieceSelected){
            drawBoard(canvas);
        }


        //get the indicies of the piece clicked for the array
        int xSpaceClickedForArrayIndex = (int) (Math.floor(m.getX() / 75));
        int ySpaceClickedForArrayIndex = (int) (Math.floor(m.getY()/75));
        this.pieceSelectedX = pieceSelectedX;
        this.pieceSelectedY = pieceSelectedY;



        //Get the position of the tile clicked so can modify tile and make it apparent that it has been selected
        int pieceSelectedX = ((int) (Math.floor(m.getX() / 75))) * 75;
        int pieceSelectedY = ((int) (Math.floor(m.getY() / 75))) * 75;

        //the tiles are filled in the canvas from index 0 to 63, then the images go from 64 + 16
        String getTileInfo = "";
        int getIndex = -1;
        for (int i = 0; i < 64; i++){
            Node n = canvas.getChildren().get(i);
            if (n.toString().contains("Rectangle[x=" + (double) pieceSelectedX + ", y=" + (double) pieceSelectedY)){
                getIndex = i;
                getTileInfo = n.toString();
            }
        }

        //remove the current tile selected to replace it with one that has an outline
        canvas.getChildren().remove(getIndex);

        //here we need to get tile colour
        String[] tileColorParse = getTileInfo.split("fill");
        String tileColor = tileColorParse[1].substring(1, tileColorParse[1].length()-1);

        //"modifying" i.e adding the tile/rectangle on the canvas
        Rectangle r = new Rectangle(pieceSelectedX, pieceSelectedY, 75, 75);
        r.setFill(Color.web(tileColor));
        r.setStroke(Color.RED);
        canvas.getChildren().add(r);


        drawPiecesOnBoard(); //draw pieces on board to prevent the pieces to be overdrawn
        this.pieceSelected = true;










        
















    }
}


