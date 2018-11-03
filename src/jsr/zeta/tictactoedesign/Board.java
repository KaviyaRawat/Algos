package jsr.zeta.tictactoedesign;

public interface Board {


    void display();
    boolean update(Move move, String type);
    int checkIfWon();

}
