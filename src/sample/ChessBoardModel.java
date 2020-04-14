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
import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

enum ChessPiece{
    BLACK_PAWN, BLACK_ROOK, BLACK_KNIGHT, BLACK_QUEEN, BLACK_KING, BLACK_BISHOP,

    WHITE_PAWN, WHITE_ROOK, WHITE_KNIGHT, WHITE_QUEEN, WHITE_KING, WHITE_BISHOP,

    NONE
}

public class ChessBoardModel {
    private final double CHESS_BOARD_HEIGHT = 600;
    private final double CHESS_BOARD_WIDTH = 600;
    private final int INDEX_OF_BLACK_STARTING_POSITION = 0;
    private final int INDEX_OF_WHITE_STARTING_POSITION = 8;

    public boolean pieceSelected = false;
    public int chessPieceTileIndex;
    public int chessPieceRowIndex;
    private int pieceSelectedX;
    private int pieceSelectedY;
    private int selectedPieceCanvasIndex;
    private ArrayList<Pair<Integer, Integer>> potentialMoveSpots;

    Rectangle[] brownTiles = new Rectangle[32];
    private Rectangle[] grayTiles = new Rectangle[32];

    private Pane canvas;
    private static ChessPiece[][] chessBoardLayout = {
            {ChessPiece.BLACK_ROOK, ChessPiece.BLACK_KNIGHT, ChessPiece.BLACK_BISHOP, ChessPiece.BLACK_QUEEN, ChessPiece.BLACK_KING, ChessPiece.BLACK_BISHOP, ChessPiece.BLACK_KNIGHT, ChessPiece.BLACK_ROOK},
            {ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN, ChessPiece.BLACK_PAWN},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.BLACK_BISHOP, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE, ChessPiece.NONE},
            {ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN, ChessPiece.WHITE_PAWN},
            {ChessPiece.WHITE_ROOK, ChessPiece.WHITE_KNIGHT, ChessPiece.WHITE_BISHOP, ChessPiece.WHITE_QUEEN, ChessPiece.WHITE_KING, ChessPiece.WHITE_BISHOP, ChessPiece.WHITE_KNIGHT, ChessPiece.WHITE_ROOK}
    };

    public ChessBoardModel(Pane canvas) {
        drawBoard(canvas);
    }

    public ChessPiece[][] getChessBoard() {
        return this.chessBoardLayout;
    }

    public void drawPiecesOnBoard() {
        for (int row = 0; row < 8; row++) {
            for (int tile = 0; tile < 8; tile++) {
                if (chessBoardLayout[row][tile] == ChessPiece.NONE) {
                    continue;
                }
                String imageName = "src/assets/" + chessBoardLayout[row][tile] + ".png";
                ImageView imageView;

                try {
                    FileInputStream input = new FileInputStream(imageName);
                    Image image = new Image(input);
                    imageView = new ImageView(image);
                } catch (FileNotFoundException e) {
                    System.out.println("Chess Piece not Found to Draw" + imageName.toString()); //should use logging later
                    return;
                }

                double currentTileX = tile * CHESS_BOARD_WIDTH / 8; //current tile spot, starting at 0
                imageView.setX(currentTileX + (24 / 2));

                double currentTileY = row * CHESS_BOARD_HEIGHT / 8;
                imageView.setY(currentTileY + (24 / 2));

                this.canvas.getChildren().add(imageView);
            }
        }
    }

    public static boolean isBlackPiece(int givenTile, int givenRow) {
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

    public static boolean isWhitePiece(int givenTile, int givenRow) {
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

    public static boolean isEmptyTile(int givenTile, int givenRow) {
        if (ChessBoardModel.chessBoardLayout[givenRow][givenTile] == ChessPiece.NONE) {
            return true;
        }
        return false;
    }

    public Pane getCanvas() {
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

        for (Rectangle r : brownTiles) {
            canvas.getChildren().add(r);
        }

        for (Rectangle r : grayTiles) {
            canvas.getChildren().add(r);
        }

        this.canvas = canvas;
    }


    //add check to see if the user can click on that spot - i.e. its their piece
    //show where they can move based on what piece they clicked
    public void getSelectedPiece(MouseEvent m) {
        if (!Game.gameRunning) {
            return;
        }

        //get the indicies of the piece clicked for the array
        int xSpaceClickedForArrayIndex = (int) (Math.floor(m.getX() / 75));
        int ySpaceClickedForArrayIndex = (int) (Math.floor(m.getY() / 75));
        this.chessPieceTileIndex = xSpaceClickedForArrayIndex;
        this.chessPieceRowIndex = ySpaceClickedForArrayIndex;


        //here we are checking if they can click that space
        if (isEmptyTile(xSpaceClickedForArrayIndex, ySpaceClickedForArrayIndex)) {
            return;
        }
        if (Game.currentPlayer == Player.BLACK && isWhitePiece(xSpaceClickedForArrayIndex, ySpaceClickedForArrayIndex)) {
            return;
        } else if (Game.currentPlayer == Player.WHITE && isBlackPiece(xSpaceClickedForArrayIndex, ySpaceClickedForArrayIndex)) {
            return;
        }

        //if we already have a piece selected, here we redraw board and pieces to get remove the other highlight of the piece selected, better way of handling this is figuring out which piece is selected
        if (pieceSelected) {
            drawBoard(canvas);
            drawPiecesOnBoard();
            this.pieceSelected = false;
            this.canvas.getChildren().remove(this.selectedPieceCanvasIndex); //removing the previously drawn tile that was selected as to not overflow the canvas
        }

        //Get the position of the tile clicked so can modify tile and make it apparent that it has been selected
        int pieceSelectedX = ((int) (Math.floor(m.getX() / 75))) * 75;
        int pieceSelectedY = ((int) (Math.floor(m.getY() / 75))) * 75;

        this.pieceSelectedX = pieceSelectedX;
        this.pieceSelectedY = pieceSelectedY;

        //the tiles are filled in the canvas from index 0 to 63, then the images go from 64 + 16
        String getTileInfo = "";
        for (int i = 0; i < canvas.getChildren().size(); i++) {
            Node n = canvas.getChildren().get(i);
            if (n.toString().contains("Rectangle[x=" + (double) pieceSelectedX + ", y=" + (double) pieceSelectedY)) {
                this.canvas.getChildren().remove(i); //remove the tile piece because we'll replace it with a redrawn updated one
                getTileInfo = n.toString(); //need info of the tile in order to populate the replacing one
                break;
            }
        }

        //here we need to get tile colour
        String[] tileColorParse = getTileInfo.split("fill");
        String tileColor = tileColorParse[1].substring(1, tileColorParse[1].length() - 1);
        //this try block handles if you click on the same spot as piece selected, weird bug
        try{
            tileColor = tileColor.split(",")[0];
        }catch (Exception e){

        }
        boolean colorWhite = false;
        if (tileColor.equals("0xffffffff")){
            colorWhite = true;
        }


        //"modifying" i.e adding the tile/rectangle on the canvas
        Rectangle r = new Rectangle(pieceSelectedX, pieceSelectedY, 75, 75);
        if (colorWhite){
            r.setFill(Color.WHITE);
        }else{
            r.setFill(Color.GRAY);
        }

        r.setStroke(Color.RED);
        this.canvas.getChildren().add(r);
        this.selectedPieceCanvasIndex = this.canvas.getChildren().size() - 1; //this is the index of the selectedPiece because we technically replace it


        //this code prevents the chess pieces to overlap ontop of each other when below drawPiecesOnBoard() is called;
        for (Iterator<Node> it = this.canvas.getChildren().iterator(); it.hasNext(); ) {
            Node n = it.next();
            if (n instanceof ImageView) {
                it.remove();
            }
        }

        drawPiecesOnBoard(); //redrawing pieces because the selected tile outline overlaps the chess piece png.
        this.pieceSelected = true; //we have selected a piece



        //NOTE: need to check whether there is a piece selected and where user clicked. IF Pieceselected && clicked on a potentialmovespot then we have to set this.potentialMovespots = null and move piece to that position
        this.potentialMoveSpots = Game.getPotentialMoveSpots(this.getChessBoard(), this.chessPieceRowIndex, this.chessPieceTileIndex); //this will handle potential move spots
        for (Pair<Integer, Integer> e : this.potentialMoveSpots){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println("---------------------");

        }

        drawPotentialMoveSpots(this.potentialMoveSpots);


    }


    //need to consider what to do when attacking a piece exists on that spot
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


            //this code prevents the chess pieces to overlap ontop of each other when below drawPiecesOnBoard() is called;
            for (Iterator<Node> it = this.canvas.getChildren().iterator(); it.hasNext(); ) {
                Node n = it.next();
                if (n instanceof ImageView) {
                    it.remove();
                }
            }

            drawPiecesOnBoard(); //redrawing pieces because the selected tile overlaps the chess piece png if there is a piece there
        }
    }
}



