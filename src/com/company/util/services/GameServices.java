package com.company.util.services;

import com.company.model.*;
import com.company.util.GameStatus;

public class GameServices {


    private void nextStep(Game game) {

        int currentIndex = game.getCurrentIndex();
        ++currentIndex;
        game.setCurrentIndex(currentIndex);

        if (game.getCurrentIndex() >= game.getPlayers().length) {
            game.setCurrentIndex(0);
        }
    }

    public void process(Game game, Battlefield bf, Player player, Point p, GameStatus state, InputServices inS, Input in) {

        if (game.getState() != GameStatus.Doing &&
                game.getPlayers()[0].isMapFilled(player) &&
                game.getPlayers()[1].isMapFilled(player)) {
            game.setState(GameStatus.Doing); //хзхз
        }

        game.getPlayers()[game.getCurrentIndex()].process(bf, player, p, state, inS, in);

        nextStep(game);
    }

    public void setGameOver(Game game) {
        game.setGameOver(true);
    }

    public boolean isGameOver(Game game) {
        return game.getIsGameOver();
    }
}
