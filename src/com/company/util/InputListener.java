package com.company.util;

import com.company.model.*;
import com.company.util.services.ShipServices;

public interface InputListener {

    boolean addNewShip(ShipDeckCount decks, Orientation orient, Point startCoord);

    void attack(int x, int y);

    void quitGame();

    void autoFill(Battlefield bf, ShipFiller sf, Player player, ShipServices ss);

}