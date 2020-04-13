package sample;

import javafx.util.Pair;

import java.util.ArrayList;

enum Player{
    WHITE,
    BLACK
}



public class Game {
    public static boolean gameRunning = true;
    public static Player currentPlayer = Player.BLACK;

    public Game() {

    }


    public static ArrayList<Pair<Integer,Integer>> getPotentialMoveSpots(ChessPiece[][] chessBoard, int row, int tile) {
        ChessPiece selectedPiece = chessBoard[row][tile];
        ArrayList<Pair<Integer, Integer>> potentialMoveSpots = new ArrayList<>();

            //HANDLING PAWNS HERE
            if (selectedPiece == ChessPiece.WHITE_PAWN || selectedPiece == ChessPiece.BLACK_PAWN){
                //HANDLING MOVEMENT UP THE BOARD - NEED TO HANDLE SPECIAL MOVEMENT BACKWARDS WHEN KINGED? IDK READ ABOUT IT
                if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1  <= 7 && chessBoard[row+1][tile] == ChessPiece.NONE){
                    Pair<Integer, Integer> pair = new Pair<>(row+1, tile);
                    potentialMoveSpots.add(pair);
                }if(selectedPiece == ChessPiece.BLACK_PAWN && row + 2  <= 7 && chessBoard[row+2][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row+2, tile);
                    potentialMoveSpots.add(pair);
                }if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1  >=0  && chessBoard[row-1][tile] == ChessPiece.NONE){
                    Pair<Integer, Integer> pair = new Pair<>(row-1, tile);
                    potentialMoveSpots.add(pair);
                }if(selectedPiece == ChessPiece.WHITE_PAWN && row - 2 >= 0 && chessBoard[row-2][tile] == ChessPiece.NONE){
                    Pair<Integer, Integer> pair = new Pair<>(row-2, tile);
                    potentialMoveSpots.add(pair);
                }

                //HANDLING POTENTIAL ATTACK
                if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1  <= 7 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(tile+1, row+1)){
                    Pair<Integer, Integer> pair = new Pair<>(row+1, tile+1);
                    potentialMoveSpots.add(pair);
                }if(selectedPiece == ChessPiece.BLACK_PAWN && row + 1  <= 7 && tile - 1 >= 0 && ChessBoardModel.isWhitePiece(tile-1, row+1)) {
                    Pair<Integer, Integer> pair = new Pair<>(row+1, tile-1);
                    potentialMoveSpots.add(pair);
                }if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1  >=0  && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(tile+1, row-1)){
                    Pair<Integer, Integer> pair = new Pair<>(row-1, tile+1);
                    potentialMoveSpots.add(pair);
                }if(selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && tile - 1 >= 0 && ChessBoardModel.isBlackPiece(tile-1, row -1)){
                    Pair<Integer, Integer> pair = new Pair<>(row-1, tile-1);
                    potentialMoveSpots.add(pair);
                }
            }


            //HANDLING ROOKS HERE




            return potentialMoveSpots;

        }


    }

