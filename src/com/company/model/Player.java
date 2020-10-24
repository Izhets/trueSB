package com.company.model;

import com.company.util.GameStatus;
import com.company.util.InputListener;
import com.company.util.ShipDeckCount;
import com.company.util.services.BasePlayerService;
import com.company.util.services.BattlefieldService;
import com.company.util.services.InputServices;
import com.company.util.services.ShipServices;

import java.util.List;
import java.util.Map;

public class Player {

    protected java.util.Map<ShipDeckCount, Integer> shipCounter;
    protected java.util.List<ShipServices> shipS;
    protected java.util.List<Ship> ships;

    protected int maxShips;
    protected int aliveShips;

    protected BattlefieldService bfS;
    protected Battlefield bf;


    protected ShipFiller filler;
    private Input input;


    public Player(Game game, Player player, BasePlayerService bps) {

        player.setGame(game);
        player.setBfS(new BattlefieldService());

        bps.init(player);
    }

    public Player (Player player, Game game, InputListener listener, InputServices is,  Input in, String inputString, Battlefield bf, ShipFiller sf, ShipServices ss ) {
        super();
        player.setInput(new Input(listener, is, in, inputString, bf, sf, player, ss)); //Снова сомнительно
    }

    public void setGame(Game game) {
        this.game = game;
    }

    protected Game game;

    public BattlefieldService getBfS() {
        return bfS;
    }

    public void setBfS(BattlefieldService bfS) {
        this.bfS = bfS;
    }

    public Battlefield getBf() {
        return bf;
    }

    public void setBf(Battlefield bf) {
        this.bf = bf;
    }

    public Map<ShipDeckCount, Integer> getShipCounter() {
        return shipCounter;
    }

    public void setShipCounter(Map<ShipDeckCount, Integer> shipCounter) {
        this.shipCounter = shipCounter;
    }


    public List<ShipServices> getShipS() {
        return shipS;
    }

    public void setShipS(List<ShipServices> shipS) {
        this.shipS = shipS;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public int getMaxShips() {
        return maxShips;
    }

    public void setMaxShips(int maxShips) {
        this.maxShips = maxShips;
    }


    public int getAliveShips() {
        return aliveShips;
    }

    public int getAliveShipsImplements() {
        return ++aliveShips;
    }

    public void setAliveShips(int aliveShips) {
        this.aliveShips = aliveShips;
    }


    public ShipFiller getFiller() {
        return filler;
    }

    public void setFiller(ShipFiller filler) {
        this.filler = filler;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Game getGame() {
        return game;
    }


    public boolean isMapFilled(Player player) {
        return player.getMaxShips() == player.getShips().size();
    }

    public void process(Battlefield bf, Player player, Point p, GameStatus state, InputServices inS, Input in) {
        player.getBfS().drawBattlefield(bf, p);
    }
}
