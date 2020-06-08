package com.presman.chess.ChessBoardHandler;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ChessBoardModel {
    private final double CHESS_BOARD_HEIGHT = 600;
    private final double CHESS_BOARD_WIDTH = 600;

    public boolean pieceSelected = false;
    public int chessPieceTileIndex;
    public int chessPieceRowIndex;

    public ArrayList<Pair<Integer, Integer>> potentialMoveSpots;
    private Rectangle temp;

    Rectangle[] brownTiles = new Rectangle[32];
    private Rectangle[] grayTiles = new Rectangle[32];

    private Pane canvas;
    private static ChessPiece[][] chessBoardLayout = {
            {ChessPiece.BLACK_ROOK, ChessPiece.BLACK_KNIGHT, ChessPiece.BLACK_BISHOP, ChessPiece.BLACK_QUEEN, ChessPiece.BLACK_KING, ChessPiece.BLACK_BISHOP, ChessPiece.BLACK_KNIGHT, ChessPiece.BLACK_ROOK},
            {ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN},
            {ChessPiece.WHITE_ROOK, ChessPiece.WHITE_KNIGHT, ChessPiece.WHITE_BISHOP, ChessPiece.WHITE_QUEEN, ChessPiece.WHITE_KING, ChessPiece.WHITE_BISHOP, ChessPiece.WHITE_KNIGHT, ChessPiece.WHITE_ROOK}
    };

    public ChessBoardModel(Pane canvas)
    {
        this.canvas = canvas;
        drawBoard(canvas);
    }
    public static ChessPiece[][] getChessBoard() {
        return chessBoardLayout;
    }

    public void redrawPieces(){
        for (Iterator<Node> it = this.canvas.getChildren().iterator(); it.hasNext(); ) {
            Node n = it.next();
            if (n instanceof ImageView) {
                it.remove();
            }
        }
        drawPiecesOnBoard();
    }

    public void drawPiecesOnBoard() {
        for (int row = 0; row < 8; row++) {
            for (int tile = 0; tile < 8; tile++) {
                if (chessBoardLayout[row][tile] == ChessPiece.NONE) {
                    continue;
                }

                String imageName = "assets/" + chessBoardLayout[row][tile] + ".png"; //for production
                ImageView imageView = null;

                String imageNameDev = "src/assets/" + chessBoardLayout[row][tile] + ".png"; //for development
                boolean success = false;

                while (!success) {
                    try {
                        FileInputStream input = new FileInputStream(imageName);
                        Image image = new Image(input);
                        imageView = new ImageView(image);
                        imageName = imageNameDev;
                        success = true;
                    } catch (FileNotFoundException e) {
                        imageName = imageNameDev;
                        continue;
                    }
                }

                double currentTileX = tile * CHESS_BOARD_WIDTH / 8; //current tile spot, starting at 0
                imageView.setX(currentTileX + (24 / 2));

                double currentTileY = row * CHESS_BOARD_HEIGHT / 8;
                imageView.setY(currentTileY + (24 / 2));

                this.canvas.getChildren().add(imageView);
            }
        }
    }

    public static boolean isBlackPiece(int givenRow, int givenTile) {
        switch (ChessBoardModel.chessBoardLayout[givenRow][givenTile]) {
            case BLACK_PAWN:
            case BLACK_QUEEN:
            case BLACK_BISHOP:
            case BLACK_KING:
            case BLACK_ROOK:
            case BLACK_KNIGHT:
                return true;
            default:
                return false;
        }
    }

    public static boolean isWhitePiece(int givenRow, int givenTile) {
        switch (ChessBoardModel.chessBoardLayout[givenRow][givenTile]) {
            case WHITE_PAWN:
            case WHITE_QUEEN:
            case WHITE_BISHOP:
            case WHITE_KING:
            case WHITE_ROOK:
            case WHITE_KNIGHT:
                return true;
            default:
                return false;
        }
    }

    public static boolean isEmptyTile(int givenRow, int givenTile) {
        if (ChessBoardModel.chessBoardLayout[givenRow][givenTile] == ChessPiece.NONE) {
            return true;
        }
        return false;
    }

    public Pane getCanvas() {
        return this.canvas;
    }

    public void drawBoard(Pane canvas) {
        for (Iterator<Node> it = this.canvas.getChildren().iterator(); it.hasNext(); ) {
            Node n = it.next();
            it.remove();
            }




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

        for (Rectangle r : brownTiles) {
            canvas.getChildren().add(r);
        }

        for (Rectangle r : grayTiles) {
            canvas.getChildren().add(r);
        }

        if (this.pieceSelected){
            canvas.getChildren().add(this.temp);
        }


        this.canvas = canvas;
    }

    public void getSelectedPiece(MouseEvent m) {
        //get the indicies of the piece clicked for the array
        int xSpaceClickedForArrayIndex = (int) (Math.floor(m.getX() / 75));
        int ySpaceClickedForArrayIndex = (int) (Math.floor(m.getY() / 75));
        this.chessPieceTileIndex = xSpaceClickedForArrayIndex;
        this.chessPieceRowIndex = ySpaceClickedForArrayIndex;


        //Get the position of the tile clicked so can modify tile and make it apparent that it has been selected
        int pieceSelectedX = ((int) (Math.floor(m.getX() / 75))) * 75;
        int pieceSelectedY = ((int) (Math.floor(m.getY() / 75))) * 75;

        for (int i = 0; i < canvas.getChildren().size(); i++) {
            Node n = canvas.getChildren().get(i);
            if (n.toString().contains("Rectangle[x=" + (double) pieceSelectedX + ", y=" + (double) pieceSelectedY)) {
                this.canvas.getChildren().remove(i); //remove the tile piece because we'll replace it with a redrawn updated one
                break;
            }
        }

        //"modifying" i.e adding the selected tile/rectangle on the canvas
        Rectangle r = new Rectangle(pieceSelectedX, pieceSelectedY, 75, 75);
        r.setFill(Color.LIGHTGOLDENRODYELLOW);
        r.setStroke(Color.BLACK);
        this.canvas.getChildren().add(r);
        this.temp = r;
        this.pieceSelected = true; //we have selected a piece


        drawBoard(this.getCanvas()); //redrawing pieces because the selected tile outline overlaps the chess piece png.
        redrawPieces(); //this prevents the chess pieces to overlap ontop of each other when below drawPiecesOnBoard() is called;


        this.potentialMoveSpots = GameModel.getPotentialMoveSpots(this.getChessBoard(), this.chessPieceRowIndex, this.chessPieceTileIndex); //this will handle potential move spots// }
        drawPotentialMoveSpots(this.potentialMoveSpots);


    }

    public void drawPotentialMoveSpots(ArrayList<Pair<Integer, Integer>> potentialMoveSpots) {
        //this is only responsible for drawing spot, not checking whther it can draw

        //note .getKey() returns the row of the potentialMoveSpot
        // .getValue() returns the tile of the potentialMoveSpot
        for (Pair<Integer, Integer> e : potentialMoveSpots) {
            int canvasXPosition = e.getValue() * 75;
            int canvasYPosition = e.getKey() * 75;

            for (int i = 0; i < this.canvas.getChildren().size(); i++){
                Node n = canvas.getChildren().get(i);
                if (n.toString().contains("Rectangle[x=" + (double) canvasXPosition + ", y=" + (double) canvasYPosition)) {
                    this.canvas.getChildren().remove(i); //remove the tile piece because we'll replace it with a redrawn updated one
                    break;
                }
            }

            Rectangle r = new Rectangle(canvasXPosition, canvasYPosition, 75, 75);
            r.setFill(Color.LIGHTGOLDENRODYELLOW);
            r.setStroke(Color.BLACK);
            this.canvas.getChildren().add(r);

            redrawPieces();
        }
    }
}



