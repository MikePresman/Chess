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
        if (!GameModel.gameRunning) {
            return;
        }

        //Moving Piece Check
        int xSpaceClickedForArrayIndex = (int) (Math.floor(m.getX() / 75));
        int ySpaceClickedForArrayIndex = (int) (Math.floor(m.getY() / 75));
        Pair<Integer, Integer> t = new Pair<>(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex);
        if (this.board.pieceSelected == true && this.board.potentialMoveSpots.contains(t)) {
            handleMovingPiece(xSpaceClickedForArrayIndex, ySpaceClickedForArrayIndex);
            return;
        } else if (this.board.pieceSelected && !this.board.potentialMoveSpots.contains(t)) {
            if (ChessBoardModel.isEmptyTile(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
                return;
            }
            if (GameModel.currentPlayer == Player.BLACK && ChessBoardModel.isWhitePiece(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
                return;
            } else if (GameModel.currentPlayer == Player.WHITE && ChessBoardModel.isBlackPiece(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
                return;
            }

            this.board.pieceSelected = false;
            this.board.drawBoard(this.board.getCanvas());
            this.board.redrawPieces();
        }



        //If spot clickable check
        if (ChessBoardModel.isEmptyTile(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
            return;
        }
        if (GameModel.currentPlayer == Player.BLACK && ChessBoardModel.isWhitePiece(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
            return;
        } else if (GameModel.currentPlayer == Player.WHITE && ChessBoardModel.isBlackPiece(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
            return;
        }


        //getSelectedPiece
        ArrayList<Pair<Integer, Integer>> potenialSpots = this.board.getSelectedPiece(m);
        this.board.drawPotentialMoveSpots(potenialSpots);


    }

    public void handleMovingPiece(int xSpaceClickedForArrayIndex, int ySpaceClickedForArrayIndex) {
        for (int i = 0; i < this.board.potentialMoveSpots.size(); i++) {
            if (this.board.potentialMoveSpots.get(i).getKey() == ySpaceClickedForArrayIndex && this.board.potentialMoveSpots.get(i).getValue() == xSpaceClickedForArrayIndex) {
                ChessBoardModel.getChessBoard()[ySpaceClickedForArrayIndex][xSpaceClickedForArrayIndex] = ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex];
                ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex] = ChessPiece.NONE;
                this.board.pieceSelected = false;
                this.board.drawBoard(this.board.getCanvas());
                this.board.redrawPieces();
                GameModel.currentPlayer = GameModel.currentPlayer == Player.WHITE ? Player.BLACK : Player.WHITE;
                return;
            } else {
                continue;
            }

        }

    }
}
