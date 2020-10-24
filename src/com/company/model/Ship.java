package com.company.model;

import com.company.util.Orientation;
import com.company.util.ShipDeckCount;
import com.company.util.services.BattlefieldService;

public class Ship {

    private Deck [] decks;
    private ShipDeckCount deckCount;
    private Orientation orientation;
    private Point[] coords;

    public Ship() {
        decks = null;
        deckCount = ShipDeckCount.invalid;
        orientation = Orientation.None;
        coords = null;
    }

    public Ship(BattlefieldService bfs, Battlefield bf, ShipDeckCount deckCount, Orientation orientation, Point[] coords) {

        this.deckCount = deckCount;
        this.orientation = orientation;
        this.coords = coords;
        this.decks = new Deck[deckCount.getValue()];

        for (int i = 0; i < this.decks.length; ++i) {
            Deck deck = new Deck(coords[i], 'O', 'X');
            this.decks[i] = deck;
            bfs.addObject(bf, deck);
        }
    }

    public Deck[] getDecks() {
        return decks;
    }

    public ShipDeckCount getDeckCount() {
        return deckCount;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Point[] getCoords() {
        return coords;
    }

}
