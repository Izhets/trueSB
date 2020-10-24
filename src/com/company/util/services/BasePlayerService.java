package com.company.util.services;

import com.company.model.*;
import com.company.util.GameStatus;
import com.company.util.InputListener;
import com.company.util.Orientation;
import com.company.util.ShipDeckCount;

public class BasePlayerService {

//    public BasePlayerService(Game game, Player player) {
//
//        player.setGame(game);
//        player.setBfS(new BattlefieldService());
//
//        init();
//    }

    public final void init(Player player) {

        player.setMaxShips(0);
        player.setAliveShips(0);
        player.setFiller(new ShipFiller(this));
        player.setShipCounter(new java.util.HashMap<ShipDeckCount, Integer>());

        for (int i = 1; i < ShipDeckCount.values().length; ++i) {
            int shipCount = 5 - i;
            player.getShipCounter().put(ShipDeckCount.valueOf(i), shipCount);
            // _max_ships = _max_ships + ship_count;
            player.setMaxShips(player.getMaxShips() + shipCount);
        }

        if (player.getMaxShips() > 0) {
            player.setShipS(new java.util.ArrayList<ShipServices>());
        }
    }

    // return free places for ships
    public int getFreePlaces(Player player, ShipDeckCount dc) {
        return player.getShipCounter().get(dc);
    }

    public boolean isPosiblePlace(Battlefield bf, Player player, Orientation orient, ShipDeckCount dc, Point startCoord) {

        Point step = orient.getDirection();
        boolean isPosiblePlace = true;
        Point position = new Point(startCoord.getX(), startCoord.getY());

        for (int i = 0; i < dc.getValue(); ++i) {
            isPosiblePlace = player.getBfS().isValidCoord(bf, position) &&
                    !player.getBfS().isCollide(bf, position) &&
                    !player.getBfS().hasNeighbours(bf, position);

            if (!isPosiblePlace) {
                break;
            }

            position.setX(position.getX() + step.getX());
            position.setY(position.getY() + step.getY());
        }

        return isPosiblePlace;
    }

    public boolean addShip(Player player, Orientation orient, ShipDeckCount dc, Point startCoord) {

        int freePlaces = getFreePlaces(player, dc);

        if (freePlaces > 0) {
            Point[] coords = ShipServices.getCoordsForShip(player.getBfS(), player.getBf(), dc, orient, startCoord);
            if (coords == null) {
                return false;
            }

            Ship ship = new Ship(player.getBfS(), player.getBf(), dc, orient, coords);

            player.getShips().add(ship);
            //free_places = free_places - 1;
            freePlaces -= 1;
            player.getShipCounter().replace(dc, freePlaces);
            player.getAliveShipsImplements(); //хзхзхз

            return true;
        }

        return false;
    }

    public void process(Battlefield bf, Player player, Point p, GameStatus state, InputServices inS, Input in) {
        player.getBfS().drawBattlefield(bf, p);
    }

    public boolean isMapFilled(Player player) {
        return player.getMaxShips() == player.getShips().size();
    }

}
