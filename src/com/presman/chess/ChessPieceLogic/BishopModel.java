package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class BishopModel {


    public void diagonalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
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

            //diagnoal down right
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
        }
    }
