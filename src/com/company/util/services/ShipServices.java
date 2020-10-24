package com.company.util.services;

import com.company.model.*;
import com.company.util.Orientation;
import com.company.util.ShipDeckCount;

import java.util.Random;

public class ShipServices {

    public void shipCoords(BattlefieldService bfs,Battlefield bf, ShipDeckCount deckCount, Orientation orientation, Point[] coords, Ship ship) {
        for (int i = 0; i < ship.getDecks().length; ++i) {
            Deck deck = new Deck(coords[i], 'O', 'X');
            ship.getDecks()[i] = deck;
            bfs.addObject(bf, deck);
        }
    }

    public static Point[] getCoordsForShip(BattlefieldService bfs, Battlefield bf, ShipDeckCount deckCount, Orientation orientation, Point startCoord) {

        Point step = orientation.getDirection();
        boolean isPossiblePlace = true;

        Point[] coords = new Point[deckCount.getValue()];
        Point position = new Point(startCoord.getX(), startCoord.getY());

        for (int i = 0; i < deckCount.getValue(); ++i) {
            isPossiblePlace = bfs.isValidCoord(bf, position) &&
                    !bfs.isCollide(bf, position) &&
                    !bfs.hasNeighbours(bf, position);
            if (!isPossiblePlace) {
                break;
            }

            coords[i] = new Point(position.getX(), position.getY());

           // position.getX() = position.getX() + step.x;
            //position.getY() = position.getY() + step.y;
        }

        if (isPossiblePlace) {
            return coords;
        }

        return null;
    }

    public void autoFillingShips(Battlefield bf, ShipFiller sf, Player player) {

        Random rand = new Random();

        for (int i = 1; i < ShipDeckCount.values().length; ++i) {
            ShipDeckCount dc = ShipDeckCount.valueOf(i);
            while (sf.getPlayer().getFreePlaces(player, dc) > 0) {
                Orientation orient = rand.nextInt(2) > 0 ? Orientation.Horizontal
                        : Orientation.Vertical;
                do {
                    int x = rand.nextInt(10);
                    int y = rand.nextInt(10);

                    Point coord = new Point(x, y);

                    if (sf.getPlayer().isPosiblePlace(bf, player, orient, dc, coord)) {
                        sf.getPlayer().addShip(player,orient, dc, coord);

                        break;
                    }
                }
                while (true);
            }
        }
    }


}
