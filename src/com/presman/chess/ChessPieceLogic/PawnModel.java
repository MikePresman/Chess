package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardModel;
import com.presman.chess.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class PawnModel implements UniqueMovement, Movement {
    @Override
    public void horizontalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {

    }

    @Override
    public void diagonalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots,  ChessPiece selectedPiece, int row, int tile) { }


    @Override
    public void verticalMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        //HANDLING MOVEMENT UP THE BOARD - NEED TO HANDLE SPECIAL MOVEMENT BACKWARDS WHEN KINGED? IDK READ ABOUT IT
        ChessPiece[][] chessBoard = ChessBoardModel.getChessBoard();
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row+1, tile)) {
            Pair<Integer, Integer> pair = new Pair<>(row + 1, tile);
            potentialMoveSpots.add(pair);
        }
        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0  && ChessBoardModel.isEmptyTile(row-1, tile)){
            Pair<Integer, Integer> pair = new Pair<>(row - 1, tile);
            potentialMoveSpots.add(pair);
        }


        //HANDLING POTENTIAL ATTACK
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(row + 1, tile + 1)) {
            Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 1);
            potentialMoveSpots.add(pair);
        }
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isWhitePiece(row+1, tile - 1)) {
            Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 1);
            potentialMoveSpots.add(pair);
        }
        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(row -1, tile + 1)) {
            Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 1);
            potentialMoveSpots.add(pair);
        }
        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && tile - 1 >= 0 && ChessBoardModel.isBlackPiece(row - 1, tile - 1)) {
            Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 1);
            potentialMoveSpots.add(pair);
        }
    }




    @Override
    public void uniqueMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        ChessPiece[][] chessBoard = ChessBoardModel.getChessBoard();
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row+2,tile) && ChessBoardModel.isEmptyTile(row+1, tile) && row == 1) {
            Pair<Integer, Integer> pair = new Pair<>(row + 2, tile);
            potentialMoveSpots.add(pair);
        }

        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row-2, tile)  && ChessBoardModel.isEmptyTile(row - 1, tile) && row == 6) {
            Pair<Integer, Integer> pair = new Pair<>(row - 2, tile);
            potentialMoveSpots.add(pair);
        }

    }
}
