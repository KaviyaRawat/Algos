package jsr.zeta.tictactoedesign;

public class TicTacToeBoard implements Board{

    int sizeX;
    int sizeY;
    String[][] board;

    TicTacToeBoard(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new String[sizeX][sizeY];
        for(int i=0; i<sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                    board[i][j] = "-1";
            }
        }
    }


    @Override
    public void display() {
        for(int i=0; i<sizeX; i++){
            for(int j=0; j<sizeY; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }

    }

    @Override
    public boolean update(Move move, String type){
        if(move.getX()>=sizeX || move.getY()>=sizeY){
            return false;
        }
        if(board[move.getX()][move.getY()].equals("-1")){
            board[move.getX()][move.getY()] = type;
            return true;
        }
        return false;

    }

    public int checkIfWon(){
        // TODO
        return 0;
    }

}
