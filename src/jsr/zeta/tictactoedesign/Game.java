package jsr.zeta.tictactoedesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    String name;
    Board board;
    List<Player> players = new ArrayList<>();
    HashMap<Player, List<Move>> moveHistory = new HashMap<>();

    Player activePlayer;


    public Game(String name, int size){
        this.name = name;
        board = new TicTacToeBoard(size, size);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        players.add(player);
        moveHistory.put(player, new ArrayList<>());
    }

    public HashMap<Player, List<Move>> getMoveHistory() {
        return moveHistory;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addMoveHistory(Player player, Move move){
        List<Move> list;
        if(moveHistory.get(player)== null){
            list = new ArrayList<>();
        }
        else{
            list = moveHistory.get(player);
        }

        list.add(move);
        moveHistory.put(player,list);

    }



}
