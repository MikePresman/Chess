package sample;


import javafx.util.Pair;

import java.util.ArrayList;

enum Player {
    WHITE,
    BLACK
}


public class Game {
    public static boolean gameRunning = true;
    public static Player currentPlayer = Player.BLACK;

    public Game() {

    }



    public static ArrayList<Pair<Integer, Integer>> getPotentialMoveSpots(ChessPiece[][] chessBoard, int row, int tile) {
        ChessPiece selectedPiece = chessBoard[row][tile];
        ArrayList<Pair<Integer, Integer>> potentialMoveSpots = new ArrayList<>();

        //HANDLING PAWNS HERE - Can't go backwards
        if (selectedPiece == ChessPiece.WHITE_PAWN || selectedPiece == ChessPiece.BLACK_PAWN) {
            //HANDLING MOVEMENT UP THE BOARD - NEED TO HANDLE SPECIAL MOVEMENT BACKWARDS WHEN KINGED? IDK READ ABOUT IT
            if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && chessBoard[row + 1][tile] == ChessPiece.NONE) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile);
                potentialMoveSpots.add(pair);
            }
            if (selectedPiece == ChessPiece.BLACK_PAWN && row + 2 <= 7 && chessBoard[row + 2][tile] == ChessPiece.NONE && chessBoard[row + 1][tile] == ChessPiece.NONE) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile);
                potentialMoveSpots.add(pair);
            }
            if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && chessBoard[row - 1][tile] == ChessPiece.NONE) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile);
                potentialMoveSpots.add(pair);
            }
            if (selectedPiece == ChessPiece.WHITE_PAWN && row - 2 >= 0 && chessBoard[row - 2][tile] == ChessPiece.NONE && chessBoard[row - 1][tile] == ChessPiece.NONE) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile);
                potentialMoveSpots.add(pair);
            }

            //HANDLING POTENTIAL ATTACK
            if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(tile + 1, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isWhitePiece(tile - 1, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(tile + 1, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && tile - 1 >= 0 && ChessBoardModel.isBlackPiece(tile - 1, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
        }

        ///////////////////////////////ROOK MOVEMENT
        if (selectedPiece == ChessPiece.BLACK_ROOK) {
            //loop for vertical downward possible moves with attack
            for (int i = row + 1; i <= 7; i++) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for vertical upward possible moves with attack
            for (int i = row - 1; i >= 0; i--) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the left with attack
            for (int i = tile - 1; i >= 0; i--) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the right with attack
            for (int i = tile + 1; i <= 7; i++) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

        }
        //remember rook can move up and down
        if (selectedPiece == ChessPiece.WHITE_ROOK) {
            //loop for vertical downward possible moves with attack
            for (int i = row + 1; i <= 7; i++) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for vertical upward possible moves with attack
            for (int i = row - 1; i >= 0; i--) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the left with attack
            for (int i = tile - 1; i >= 0; i--) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the right with attack
            for (int i = tile + 1; i <= 7; i++) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }


        //KNIGHT
        //horizontal movement of bishop - no attack
        if (selectedPiece == ChessPiece.BLACK_KNIGHT) {
            if (tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row + 2) || tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isWhitePiece(tile + 1, row + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(tile - 1, row + 2) || tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isWhitePiece(tile - 1, row + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(tile + 1, row - 2) || tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isWhitePiece(tile + 1, row - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row - 2) || tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isWhitePiece(tile - 1, row - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 2, row + 1) || tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isWhitePiece(tile + 2, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(tile - 2, row + 1) || tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isWhitePiece(tile - 2, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile + 2, row - 1) || tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isWhitePiece(tile + 2, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 2, row - 1) || tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isWhitePiece(tile - 2, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
        }

        if (selectedPiece == ChessPiece.WHITE_KNIGHT) {
            if (tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row + 2) || tile + 1 <= 7 && row + 2 <= 7 && ChessBoardModel.isWhitePiece(tile + 1, row + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isEmptyTile(tile - 1, row + 2) || tile - 1 >= 0 && row + 2 <= 7 && ChessBoardModel.isBlackPiece(tile - 1, row + 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(tile + 1, row - 2) || tile + 1 <= 7 && row - 2 >= 0 && ChessBoardModel.isBlackPiece(tile + 1, row - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row - 2) || tile - 1 >= 0 && row - 2 >= 0 && ChessBoardModel.isBlackPiece(tile - 1, row - 2)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 2, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 2, row + 1) || tile + 2 <= 7 && row + 1 <= 7 && ChessBoardModel.isBlackPiece(tile + 2, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isEmptyTile(tile - 2, row + 1) || tile - 2 >= 0 && row + 1 <= 7 && ChessBoardModel.isBlackPiece(tile - 2, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
            if (tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile + 2, row - 1) || tile + 2 <= 7 && row - 1 >= 0 && ChessBoardModel.isBlackPiece(tile + 2, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 2);
                potentialMoveSpots.add(pair);
            }
            if (tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 2, row - 1) || tile - 2 >= 0 && row - 1 >= 0 && ChessBoardModel.isBlackPiece(tile - 2, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 2);
                potentialMoveSpots.add(pair);
            }
        }

        //BISHOP - CAN MOVE DIAGONALLY ANYWAY
        if (selectedPiece == ChessPiece.BLACK_BISHOP) {
            //diagnol up left
            for (int i = row - 1, j = tile - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal up right
            for (int i = row - 1, j = tile + 1; i >= 0 && j <= 7; i--, j++) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //dianonal down left
            for (int i = row + 1, j = tile - 1; i <= 7 && j >= 0; i++, j--) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal down right
            for (int i = row + 1, j = tile + 1; i <= 7 && j <= 7; i++, j++) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
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
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal up right
            for (int i = row - 1, j = tile + 1; i >= 0 && j <= 7; i--, j++) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //dianonal down left
            for (int i = row + 1, j = tile - 1; i <= 7 && j >= 0; i++, j--) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal down right
            for (int i = row + 1, j = tile + 1; i <= 7 && j <= 7; i++, j++) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }


        //KING MOVEMENT - MOVES ANYWHERE ONE BLOCK
        if (selectedPiece == ChessPiece.BLACK_KING) {
            if (row + 1 <= 7 && ChessBoardModel.isWhitePiece(tile, row + 1) || row + 1 <= 7 && ChessBoardModel.isEmptyTile(tile, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile);
                potentialMoveSpots.add(pair);
            }
            if (row - 1 >= 0 && ChessBoardModel.isWhitePiece(tile, row - 1) || row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && ChessBoardModel.isWhitePiece(tile - 1, row) || tile - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 1 <= 7 && ChessBoardModel.isWhitePiece(tile + 1, row) || tile + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isWhitePiece(tile - 1, row - 1) || tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(tile + 1, row - 1) || row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(tile + 1, row + 1) || row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isWhitePiece(tile - 1, row + 1) || row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
        }

        if (selectedPiece == ChessPiece.WHITE_KING) {
            if (row + 1 <= 7 && ChessBoardModel.isBlackPiece(tile, row + 1) || row + 1 <= 7 && ChessBoardModel.isEmptyTile(tile, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile);
                potentialMoveSpots.add(pair);
            }
            if (row - 1 >= 0 && ChessBoardModel.isBlackPiece(tile, row - 1) || row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && ChessBoardModel.isBlackPiece(tile - 1, row) || tile - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (tile + 1 <= 7 && ChessBoardModel.isBlackPiece(tile + 1, row) || tile + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row)) {
                Pair<Integer, Integer> pair = new Pair<>(row, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isBlackPiece(tile - 1, row - 1) || tile - 1 >= 0 && row - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
            if (row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(tile + 1, row - 1) || row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row - 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row - 1, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(tile + 1, row + 1) || row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isEmptyTile(tile + 1, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile + 1);
                potentialMoveSpots.add(pair);
            }
            if (row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isBlackPiece(tile - 1, row + 1) || row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isEmptyTile(tile - 1, row + 1)) {
                Pair<Integer, Integer> pair = new Pair<>(row + 1, tile - 1);
                potentialMoveSpots.add(pair);
            }
        }


        //QUEEN MOVEMENT
        if (selectedPiece == ChessPiece.BLACK_QUEEN) {

            //diagnonal down right
            for (int i = row + 1, j = tile + 1; i <= 7 && j <= 7; i++, j++) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //dianonal down left
            for (int i = row + 1, j = tile - 1; i <= 7 && j >= 0; i++, j--) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal up right
            for (int i = row - 1, j = tile + 1; i >= 0 && j <= 7; i--, j++) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnol up left
            for (int i = row - 1, j = tile - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }


            //loop for vertical downward possible moves with attack
            for (int i = row + 1; i <= 7; i++) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for vertical upward possible moves with attack
            for (int i = row - 1; i >= 0; i++) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the left with attack
            for (int i = tile - 1; i >= 0; i--) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the right with attack
            for (int i = tile + 1; i <= 7; i++) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isWhitePiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
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
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //dianonal down left
            for (int i = row + 1, j = tile - 1; i <= 7 && j >= 0; i++, j--) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnoal up right
            for (int i = row - 1, j = tile + 1; i >= 0 && j <= 7; i--, j++) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //diagnol up left
            for (int i = row - 1, j = tile - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(j, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }


            //loop for vertical downward possible moves with attack
            for (int i = row + 1; i <= 7; i++) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for vertical upward possible moves with attack
            for (int i = row - 1; i >= 0; i++) {
                if (chessBoard[i][tile] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(tile, i)) {
                    Pair<Integer, Integer> pair = new Pair<>(i, tile);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the left with attack
            for (int i = tile - 1; i >= 0; i--) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }

            //loop for horizontal possible moves to the right with attack
            for (int i = tile + 1; i <= 7; i++) {
                if (chessBoard[row][i] == ChessPiece.NONE) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                } else if (ChessBoardModel.isBlackPiece(i, row)) {
                    Pair<Integer, Integer> pair = new Pair<>(row, i);
                    potentialMoveSpots.add(pair);
                    break;
                } else {
                    break;
                }
            }
        }


        return potentialMoveSpots;
    }

}


