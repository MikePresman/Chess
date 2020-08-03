package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class KingModel {

    public void horizontalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile) || row + 1 <= 7 && ChessBoardModel.isEnemy(selectedPiece, row + 1, tile)) {
            potentialMoveSpots.add(row + 1, tile);
        }

        if (row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile) || row - 1 >= 0 && ChessBoardModel.isEnemy(selectedPiece, row - 1, tile)) {
            potentialMoveSpots.add(row - 1, tile);
        }
    }


    public void verticalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (tile - 1 >= 0 && ChessBoardModel.isEmptyTile(row, tile - 1) || tile - 1 >= 0 && ChessBoardModel.isEnemy(selectedPiece, row, tile - 1)) {
            potentialMoveSpots.add(row, tile - 1);
        }

        if (tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row, tile + 1) || tile + 1 <= 7 && ChessBoardModel.isEnemy(selectedPiece, row, tile + 1)) {
            potentialMoveSpots.add(row, tile + 1);
        }
    }


    public void diagonalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile - 1) || tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isEnemy(selectedPiece, row - 1, tile - 1)) {
            potentialMoveSpots.add(row - 1, tile - 1);
        }

        if (row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile + 1) || row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isEnemy(selectedPiece, row + 1, tile + 1)) {
            potentialMoveSpots.add(row + 1, tile + 1);
        }

        if (row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row - 1, tile + 1) || row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isEnemy(selectedPiece, row - 1, tile + 1)) {
            potentialMoveSpots.add(row - 1, tile + 1);
        }

        if (row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isEmptyTile(row + 1, tile - 1) || row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isEnemy(selectedPiece, row + 1, tile - 1)) {
            potentialMoveSpots.add(row + 1, tile - 1);
        }
    }
}




