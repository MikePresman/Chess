package com.presman.chess;

import javafx.util.Pair;

import java.util.ArrayList;

public class BishopModel implements ChessPieceMovement {

    @Override
    public void horizontalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {

    }

    @Override
    public void verticalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {

    }

    @Override
    public void diagonalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (selectedPiece == ChessPiece.BLACK_BISHOP) {
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

            //diagnoal down right
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
        }


        if (selectedPiece == ChessPiece.WHITE_BISHOP) {
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

            //diagnoal down right
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
        }
    }
}
