package com.presman.chess;

import javafx.util.Pair;

import java.util.ArrayList;

public class KnightModel implements UniqueChessPieceMovement {

    @Override
    public void horizontalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {

    }

    @Override
    public void verticalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {

    }

    @Override
    public void diagonalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {

    }

    @Override
    public void uniqueMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {

        //KNIGHT
        //horizontal movement of bishop - no attack
        if (selectedPiece == ChessPiece.BLACK_KNIGHT) {
            if (tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row + 2, tile + 1) || tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isWhitePiece(row + 2, tile + 1 )) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row + 2, tile - 1) || tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isWhitePiece(row + 2, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row - 2, tile + 1) || tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isWhitePiece(row - 2, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row - 2,  tile - 1) || tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isWhitePiece(row - 2, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile + 2) || tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isWhitePiece(row + 1, tile + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile - 2) || tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isWhitePiece(row + 1, tile - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile + 2) || tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isWhitePiece(row - 1, tile + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile - 2) || tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isWhitePiece(row - 1, tile - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
        }

        if (selectedPiece == ChessPiece.WHITE_KNIGHT) {
            if (tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row + 2, tile + 1) || tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isBlackPiece(row + 2, tile + 1 )) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row + 2, tile - 1) || tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isBlackPiece(row + 2, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row - 2, tile + 1) || tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isBlackPiece(row - 2, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row - 2,  tile - 1) || tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isBlackPiece(row - 2, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile + 2) || tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isBlackPiece(row + 1, tile + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile - 2) || tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isBlackPiece(row + 1, tile - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile + 2) || tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isBlackPiece(row - 1, tile + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile - 2) || tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isBlackPiece(row - 1, tile - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
        }
    }
}
