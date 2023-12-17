package lk.ijse.dep.service;

import lk.ijse.dep.controller.BoardController;

import java.util.ArrayList;
import java.util.List;

public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;
    public Piece piece = Piece.BLUE;
    public int cols;
    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];


        for (int i = 0;i < NUM_OF_COLS;i++) {
            for (int j = 0;j < NUM_OF_ROWS;j++){
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {
        return this.boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {

        for (int i = 0;i < NUM_OF_ROWS;i++){
            if ( pieces[col][i] == Piece.EMPTY ){
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {

        return this.findNextAvailableSpot(col) > -1;
    }

    @Override
    public boolean existLegalMoves() {

        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (this.isLegalMove(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

        this.cols=col;
        this.piece=move;


        pieces[col][findNextAvailableSpot(col)] = move;
    }

    @Override
    public void updateMove(int col, int row, Piece move) {

        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {


        for (int col = 0; col < NUM_OF_COLS; col++) {
            for (int row = 0; row < NUM_OF_ROWS; row++) {
                Piece currentPiece = pieces[col][row];

                if (currentPiece != Piece.EMPTY) {

                    if (row + 3 < NUM_OF_ROWS &&
                            currentPiece == pieces[col][row + 1] &&
                            currentPiece == pieces[col][row + 2] &&
                            currentPiece == pieces[col][row + 3]) {

                        return new Winner(currentPiece, col, row, col, row + 3);
                    }


                    if (col + 3 < NUM_OF_COLS &&
                            currentPiece == pieces[col + 1][row] &&
                            currentPiece == pieces[col + 2][row] &&
                            currentPiece == pieces[col + 3][row]) {
                        return new Winner(currentPiece, col, row, col + 3, row);
                    }
                }
            }
        }

        return new Winner(Piece.EMPTY);
    }



    public BoardImpl(Piece[][] pieces, BoardUI boardUI){
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        //copies existing 2D array to newly created array here
        for (int i = 0;i < NUM_OF_COLS;i++){
            for (int j = 0;j < NUM_OF_ROWS;j++){
                this.pieces[i][j] = pieces[i][j];
            }
        }
        this.boardUI = boardUI;
    }

    @Override
    public BoardImpl getBoardImpl() {
        return this;
    }


    public List<BoardImpl> getAllLegalNextMoves() {
        Piece nextPiece = piece == Piece.BLUE? Piece.GREEN : Piece.BLUE;

        List<BoardImpl> nextMoves = new ArrayList<>();
        for (int col = 0; col < NUM_OF_COLS; col++) {
            if (findNextAvailableSpot(col) > -1) {
                BoardImpl legalMove = new BoardImpl(this.pieces,this.boardUI);
                legalMove.updateMove(col, nextPiece);
                nextMoves.add(legalMove);
            }
        }
        return nextMoves;
    }

    public BoardImpl getRandomLegalNextMove(){
        final  List<BoardImpl> legalMoves = getAllLegalNextMoves();
        if (legalMoves.isEmpty()) {
            return null;
        }
        final int random;
        random = RANDOM_GENERATOR.nextInt(legalMoves.size());
        return legalMoves.get(random);
    }

    public boolean getStatus(){
        if (!existLegalMoves()) {
            return false;
        }
        Winner winner = findWinner();
        if (winner.getWinningPiece() != Piece.EMPTY) {
            return false;
        }
        return true;
    }
}

