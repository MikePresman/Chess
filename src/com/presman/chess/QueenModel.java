package com.presman.chess;

import javafx.concurrent.ScheduledService;
import javafx.util.Pair;

import java.util.ArrayList;

public class QueenModel implements ChessPieceMovement {

    @Override
    public void horizontalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (selectedPiece ==  ChessPiece.BLACK_QUEEN) {
            //loop for horizontal possible moves to the left with attack
            for (int i = tile - 1; i >= 0; i--) {
                if (ChessBoardModel.isEmptyTile(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the right with attack
            for (int i = tile + 1; i <= 7; i++) {
                if (ChessBoardModel.isEmptyTile(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }

        if (selectedPiece ==  ChessPiece.WHITE_QUEEN) {
            //loop for horizontal possible moves to the left with attack
            for (int i = tile - 1; i >= 0; i--) {
                if (ChessBoardModel.isEmptyTile(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the right with attack
            for (int i = tile + 1; i <= 7; i++) {
                if (ChessBoardModel.isEmptyTile(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(row, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }
    }



    @Override
    public void verticalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        //QUEEN MOVEMENT
        if (selectedPiece == ChessPiece.BLACK_QUEEN) {

            //loop for vertical downward possible moves with attack
            for (int i = row + 1; i <= 7; i++) {
                if (ChessBoardModel.isEmptyTile(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for vertical upward possible moves with attack
            for (int i = row - 1; i >= 0; i--) {
                if (ChessBoardModel.isEmptyTile(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }

        //QUEEN MOVEMENT
        if (selectedPiece == ChessPiece.WHITE_QUEEN) {

            //loop for vertical downward possible moves with attack
            for (int i = row + 1; i <= 7; i++) {
                if (ChessBoardModel.isEmptyTile(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for vertical upward possible moves with attack
            for (int i = row - 1; i >= 0; i--) {
                if (ChessBoardModel.isEmptyTile(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, tile)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void diagonalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (selectedPiece == ChessPiece.BLACK_QUEEN) {
            //diagnonal down right
            for (int i = row + 1, j = tile + 1; i <= 7 && j <= 7; i++, j++) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //dianonal down left
            for (int i = row + 1, j = tile - 1; i <= 7 && j >= 0; i++, j--) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal up right
            for (int i = row - 1, j = tile + 1; i >= 0 && j <= 7; i--, j++) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnol up left
            for (int i = row - 1, j = tile - 1; i >= 0 && j >= 0; i--, j--) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }


        if (selectedPiece == ChessPiece.WHITE_QUEEN) {
            //diagnonal down right
            for (int i = row + 1, j = tile + 1; i <= 7 && j <= 7; i++, j++) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //dianonal down left
            for (int i = row + 1, j = tile - 1; i <= 7 && j >= 0; i++, j--) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal up right
            for (int i = row - 1, j = tile + 1; i >= 0 && j <= 7; i--, j++) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnol up left
            for (int i = row - 1, j = tile - 1; i >= 0 && j >= 0; i--, j--) {
                if (ChessBoardModel.isEmptyTile(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, j)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }
    }
}
