package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class QueenModel {

    public void horizontalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        //loop for horizontal possible moves to the left with attack
        for (int i = tile - 1; i >= 0; i--) {
            if (ChessBoardModel.isEmptyTile(row, i)) {
                potentialMoveSpots.add(row, i);
            } else if (ChessBoardModel.isEnemy(selectedPiece, row, i)) {
                potentialMoveSpots.add(row, i);
                break;
            } else {
                break;
            }
        }

        //loop for horizontal possible moves to the right with attack
        for (int i = tile + 1; i <= 7; i++) {
            if (ChessBoardModel.isEmptyTile(row, i)) {
                potentialMoveSpots.add(row, i);
            } else if (ChessBoardModel.isEnemy(selectedPiece, row, i)) {
                potentialMoveSpots.add(row, i);
                break;
            } else {
                break;
            }
        }
    }


    public void verticalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        //QUEEN MOVEMENT

        //loop for vertical downward possible moves with attack
        for (int i = row + 1; i <= 7; i++) {
            if (ChessBoardModel.isEmptyTile(i, tile)) {
                potentialMoveSpots.add(i, tile);
            } else if (ChessBoardModel.isEnemy(selectedPiece, i, tile)) {
                potentialMoveSpots.add(i, tile);
                break;
            } else {
                break;
            }
        }

        //loop for vertical upward possible moves with attack
        for (int i = row - 1; i >= 0; i--) {
            if (ChessBoardModel.isEmptyTile(i, tile)) {
                potentialMoveSpots.add(i, tile);
            } else if (ChessBoardModel.isEnemy(selectedPiece, i, tile)) {
                potentialMoveSpots.add(i, tile);
                break;
            } else {
                break;
            }
        }
    }


    public void diagonalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        //diagnonal down right
        for (int i = row + 1, j = tile + 1; i <= 7 && j <= 7; i++, j++) {
            if (ChessBoardModel.isEmptyTile(i, j)) {
                potentialMoveSpots.add(i, j);
            } else if (ChessBoardModel.isEnemy(selectedPiece, i, j)) {
                potentialMoveSpots.add(i, j);
                break;
            } else {
                break;
            }
        }

        //dianonal down left
        for (int i = row + 1, j = tile - 1; i <= 7 && j >= 0; i++, j--) {
            if (ChessBoardModel.isEmptyTile(i, j)) {
                potentialMoveSpots.add(i, j);
            } else if (ChessBoardModel.isEnemy(selectedPiece, i, j)) {
                potentialMoveSpots.add(i, j);
                break;
            } else {
                break;
            }
        }

        //diagnoal up right
        for (int i = row - 1, j = tile + 1; i >= 0 && j <= 7; i--, j++) {
            if (ChessBoardModel.isEmptyTile(i, j)) {
                potentialMoveSpots.add(i, j);
            } else if (ChessBoardModel.isEnemy(selectedPiece, i, j)) {
                potentialMoveSpots.add(i, j);
                break;
            } else {
                break;
            }
        }

        //diagnol up left
        for (int i = row - 1, j = tile - 1; i >= 0 && j >= 0; i--, j--) {
            if (ChessBoardModel.isEmptyTile(i, j)) {
                potentialMoveSpots.add(i, j);
            } else if (ChessBoardModel.isEnemy(selectedPiece, i, j)) {
                potentialMoveSpots.add(i, j);
                break;
            } else {
                break;
            }
        }
    }
}

