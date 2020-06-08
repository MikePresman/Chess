package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class KingModel implements Movement {

    @Override
    public void horizontalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (selectedPiece == ChessPiece.BLACK_KING) {
            if (row + 1 <= 7 && ChessBoardModel.isWhitePiece(row + 1, tile) || row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile);
                potentialMoveSpots.add(pair);
            }

            if (row - 1 >= 0 && ChessBoardModel.isWhitePiece(row - 1, tile) || row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile);
                potentialMoveSpots.add(pair);
            }
        }

        if (selectedPiece == ChessPiece.WHITE_KING) {
            if (row + 1 <= 7 && ChessBoardModel.isBlackPiece(row + 1, tile) || row + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile);
                potentialMoveSpots.add(pair);
            }

            if (row - 1 >= 0 && ChessBoardModel.isBlackPiece(row - 1, tile) || row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile);
                potentialMoveSpots.add(pair);
            }
        }

    }

    @Override
    public void verticalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (selectedPiece == ChessPiece.BLACK_KING) {
            if (tile - 1 >= 0 && ChessBoardModel.isWhitePiece(row, tile - 1) || tile - 1 >= 0 && ChessBoardModel.isEmptyTile(row, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile - 1);
                potentialMoveSpots.add(pair);
            }

            if (tile + 1 <= 7 && ChessBoardModel.isWhitePiece(row, tile + 1) || tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile + 1);
                potentialMoveSpots.add(pair);
            }
        }

        if (selectedPiece == ChessPiece.WHITE_KING){
            if (tile - 1 >= 0 && ChessBoardModel.isBlackPiece(row, tile - 1) || tile - 1 >= 0 && ChessBoardModel.isEmptyTile(row, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile - 1);
                potentialMoveSpots.add(pair);
            }

            if (tile + 1 <= 7 && ChessBoardModel.isBlackPiece(row, tile + 1) || tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile + 1);
                potentialMoveSpots.add(pair);
            }
        }
    }

    @Override
    public void diagonalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (selectedPiece == ChessPiece.BLACK_KING) {
            if (tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isWhitePiece(row - 1, tile - 1) || tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 1);
                potentialMoveSpots.add(pair);
            }

            if (row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(row + 1, tile + 1) || row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 1);
                potentialMoveSpots.add(pair);
            }

            if (row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(row - 1, tile + 1) || row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row - 1, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 1);
                potentialMoveSpots.add(pair);
            }

            if (row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isWhitePiece(row + 1, tile - 1) || row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isEmptyTile(row + 1, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
        }

        if (selectedPiece == ChessPiece.WHITE_KING) {
            if (tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isBlackPiece(row - 1, tile - 1) || tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(row - 1, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 1);
                potentialMoveSpots.add(pair);
            }

            if (row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(row + 1, tile + 1) || row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row + 1, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 1);
                potentialMoveSpots.add(pair);
            }

            if (row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(row - 1, tile + 1) || row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(row - 1, tile + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 1);
                potentialMoveSpots.add(pair);
            }

            if (row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isBlackPiece(row + 1, tile - 1) || row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isEmptyTile(row + 1, tile - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
        }
    }

}


