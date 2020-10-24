package com.company.util.services;

import com.company.model.*;
import com.company.util.GameStatus;
import com.company.util.InputListener;
import com.company.util.Orientation;
import com.company.util.ShipDeckCount;

public class PlayerServices extends BasePlayerService implements InputListener {

//    public void process(Battlefield bf, Point p) {
//        battlefield.drawBattlefield(bf, p);
//    }
//
//    public boolean isMapFilled() {
//        return maxShips == ships.size();
//    }
//
//    public int getAliveShips() {
//        return aliveShips;
//    }

    public boolean addNewShip(Player player, ShipDeckCount decks, Orientation orient, Point startCoord) {
        System.out.println("make_ship x, y (" + startCoord.getX() + ", " + startCoord.getY() + ") " + decks);
        addShip(player, orient, decks, startCoord);

        return getFreePlaces(player, decks) > 0;
    }

    @Override
    public boolean addNewShip(ShipDeckCount decks, Orientation orient, Point startCoord) {
        return false;
    }

    public void attack(int x, int y) {

    }

    @Override
    public void quitGame() {

    }

    public void quitGame(Game game) {
        game.setGameOver(true);
    }

    @Override
    public void process(Battlefield bf, Player player, Point p, GameStatus state, InputServices inS, Input in) {
        super.process(bf, player, p, state, inS, in);
        //inS.process(game.getState()); //не фортануло
    }

    public void autoFill(Battlefield bf, ShipFiller sf, Player player, ShipServices ss) {
        ss.autoFillingShips(bf, sf, player);
    }
}