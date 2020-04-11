package sample;

enum Player{
    WHITE,
    BLACK
}



public class Game {
    public static boolean gameRunning = true;
    public static Player currentPlayer = Player.BLACK;

    public Game() {

    }

    public void movePiece() {

    }

    public static void getPotentialMoveSpots(ChessPiece[][] chessBoard, int row, int tile) {
        ChessPiece selectedPiece = chessBoard[row][tile];

        if (row + 1 < chessBoard.length - 1) {
            if (selectedPiece == ChessPiece.WHITE_PAWN || selectedPiece == ChessPiece.BLACK_PAWN) {
                if (chessBoard[row + 1][tile] == ChessPiece.NONE || chessBoard[row][tile] == ChessPiece.NONE) { //handling move
                    //get current chesspiececoordinate
                    //draw corresponding tile

                }
            }
        }

    }
}
