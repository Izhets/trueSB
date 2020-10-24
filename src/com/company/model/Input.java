package com.company.model;

import com.company.util.InputListener;
import com.company.util.services.InputServices;
import com.company.util.services.ShipServices;

import java.util.Scanner;

public class Input {

    private Scanner scan;

    private InputListener listener;

    private final String baseFillMessage = "Поставьте %d-палубный корабь (можно написать 'авто' ) в соответствии с параметрами %s:";

    private String currentMessage;

    private int currentShipDeck;

    public Input(InputListener listener, InputServices is, Input in, String inputString, Battlefield bf, ShipFiller sf, Player player, ShipServices ss) {

        this.scan = new Scanner(System.in);
        this.listener = listener;
        this.currentShipDeck = 1;

        is.updateMessage(in, inputString, bf, sf, player, ss); //мб не убдет рабоать
    }

    public int getCurrentShipDeck() {
        return currentShipDeck;
    }

    public String getCurrentMessage() {
        return currentMessage;
    }

    public String getBaseFillMessage() {
        return baseFillMessage;
    }

    public Scanner getScan() {
        return scan;
    }

    public InputListener getListener() {
        return listener;
    }

    public void setCurrentMessage(String currentMessage) {
        this.currentMessage = currentMessage;
    }

    public void setCurrentShipDeckImplements() {
        ++this.currentShipDeck;
    }
}
