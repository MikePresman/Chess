package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class RookModel {

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
    }
