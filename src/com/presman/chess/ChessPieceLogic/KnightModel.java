package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class KnightModel {
    public void uniqueMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
            if (tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row + 2, tile + 1) || tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isEnemy(selectedPiece, row + 2, tile + 1 )) {
                potentialMoveSpots.add(row+2, tile+1);
            }
            if (tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row + 2, tile - 1) || tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isEnemy(selectedPiece,row + 2, tile - 1)) {
                potentialMoveSpots.add(row+2, tile -1);
            }
            if (tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row - 2, tile + 1) || tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isEnemy(selectedPiece, row - 2, tile + 1)) {
                potentialMoveSpots.add(row - 2, tile + 1);
            }
            if (tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row - 2,  tile - 1) || tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isEnemy(selectedPiece,row - 2, tile - 1)) {
                potentialMoveSpots.add(row -2 , tile - 1);
            }
            if (tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile + 2) || tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isEnemy(selectedPiece, row + 1, tile + 2)) {
                potentialMoveSpots.add(row + 1, tile + 2);
            }
            if (tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile - 2) || tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isEnemy(selectedPiece, row + 1, tile - 2)) {
                potentialMoveSpots.add(row+1, tile - 2);
            }
            if (tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile + 2) || tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isEnemy(selectedPiece, row - 1, tile + 2)) {
                potentialMoveSpots.add(row - 1, tile + 2);
            }
            if (tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile - 2) || tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isEnemy(selectedPiece, row - 1, tile - 2)) {
                potentialMoveSpots.add(row - 1, tile - 2);
            }
        }
    }

