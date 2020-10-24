package com.company.model;

import com.company.util.GameStatus;
import com.company.util.InputListener;
import com.company.util.services.BasePlayerService;
import com.company.util.services.InputServices;

public class Game {

    private GameStatus state;
    private Player[] players;
    private int currentIndex;
    private boolean isGameOver;


    public Game(Game game, Player player, BasePlayerService bps, InputListener listener, InputServices is) {
        state = GameStatus.Initialization;
        players = new Player[2];
        //players[0] = new Player(player, game, listener, is);
        players[0] = new Player(game, player, bps);
        players[1] = new Player(game, player, bps);
        currentIndex = 0;
        isGameOver = false;
    }

    public GameStatus getState() {
        return state;
    }

    public void setState(GameStatus state) {
        this.state = state;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public boolean isGameOver(Game game) {
        return isGameOver;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Player[] getPlayers() {
        return players;
    }
}
