package com.presman.chess;

import javafx.scene.layout.Pane;


import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

import java.util.ArrayList;


public class GameController {
    private ChessBoardModel board;

    public GameController() {

    } //necessary for sample.fxml - leave it alone


    public GameController(Pane canvas) {
        this.board = new ChessBoardModel(canvas); //this will draw the board
        this.board.drawPiecesOnBoard(); //draw initial pieces
    }


    public void handleEvent(MouseEvent m) {

        //null checks
        if (!GameModel.gameRunning) {
            return;
        }

        int xSpaceClickedForArrayIndex = (int) (Math.floor(m.getX() / 75));
        int ySpaceClickedForArrayIndex = (int) (Math.floor(m.getY() / 75));


        if (this.board.pieceSelected == true) {
            for (Pair<Integer, Integer> e : this.board.potentialMoveSpots) {
                if (e.getKey() == ySpaceClickedForArrayIndex && e.getValue() == xSpaceClickedForArrayIndex) {
                    ChessBoardModel.getChessBoard()[ySpaceClickedForArrayIndex][xSpaceClickedForArrayIndex] = ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex];
                    ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex] = ChessPiece.NONE;
                    this.board.drawBoard(this.board.getCanvas());
                    this.board.redrawPieces();
                    this.board.pieceSelected = false;
                    GameModel.currentPlayer = GameModel.currentPlayer == Player.WHITE ? Player.BLACK : Player.WHITE;
                    return;
                } else {
                    return;
                }

            }
        }



        if(this.board.pieceSelected ==false&&ChessBoardModel.isEmptyTile(ySpaceClickedForArrayIndex,xSpaceClickedForArrayIndex))

    {
        return;
    }
        if(GameModel.currentPlayer ==Player.BLACK &&ChessBoardModel.isWhitePiece(ySpaceClickedForArrayIndex,xSpaceClickedForArrayIndex))

    {
        return;
    } else if(GameModel.currentPlayer ==Player.WHITE &&ChessBoardModel.isBlackPiece(ySpaceClickedForArrayIndex,xSpaceClickedForArrayIndex))

    {
        return;
    }

    //end of null checks


    ArrayList<Pair<Integer, Integer>> potenialSpots = this.board.getSelectedPiece(m);
        this.board.drawPotentialMoveSpots(potenialSpots);


}




}
