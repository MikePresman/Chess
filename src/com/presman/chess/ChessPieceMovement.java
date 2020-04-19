package com.presman.chess;

import javafx.util.Pair;

import java.util.ArrayList;

public interface ChessPieceMovement {
    public void horizontalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile);

    public void verticalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile);

    public void diagonalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile);

}

interface UniqueChessPieceMovement extends ChessPieceMovement{
    public void uniqueMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile);
}
