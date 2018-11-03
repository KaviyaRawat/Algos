package jsr.zeta.tictactoedesign;

import java.util.ArrayList;

public class Player {

    String type;
    String name;

    ArrayList<Game> games = new ArrayList<>();

    public ArrayList<Game> getGames() {
        return games;
    }

    public int play(Move move, Game game){

        if(game.getBoard().update(move, type)){
            if(game.getBoard().checkIfWon()==1)
                return 1;
            else
                return 0;

        }



        // addMoveHistory();
        game.getBoard().display();
        return -1;

    }


    public void addGames(Game game){
        games.add(game);
    }
}
