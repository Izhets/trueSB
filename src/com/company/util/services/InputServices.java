package com.company.util.services;

import com.company.model.*;
import com.company.util.GameStatus;
import com.company.util.InputListener;
import com.company.util.Orientation;
import com.company.util.ShipDeckCount;

import java.util.Scanner;

public class InputServices {

    public void updateMessage(Input in, String inputString, Battlefield bf, ShipFiller sf, Player player, ShipServices ss) {

        String format = in.getCurrentShipDeck() > 1 ? "(x,y;orientation)" : "(x,y)";
        in.setCurrentMessage(String.format(in.getBaseFillMessage(), in.getCurrentShipDeck(), format)); //Тут тоже костыли, может не работать
    }

    public void process(GameStatus state, String inputStrings, Input in, Battlefield bf, ShipFiller sf, Player player, ShipServices ss) {

        System.out.println(in.getCurrentMessage());
        String inputString = in.getScan().nextLine();
        System.out.print(inputString);

        boolean quitGame = "q".equals(inputString) || "quit".equals(inputString) || "выход".equals(inputString);

        if (in.getListener() != null) {
            if (quitGame) {
                in.getListener().quitGame();
                return;
            }
            if (state == GameStatus.Initialization) {
                fillProcess(inputStrings, in, bf, sf, player, ss);
            } else if (state == GameStatus.Doing) {
                doProcess(inputString, in);
            }
        }
    }

    private Point parseCoords(String in) {

        String[] coords = in.split(",");
        int x = -1;
        int y = -1;

        if (coords.length >= 2) {
            char symbol = Character.toLowerCase(coords[0].charAt(0));
            x = symbol - 'a';
            y = Integer.parseInt(coords[1]) - 1;
        }

        return new Point(x, y);
    }

    private void fillProcess(String inputString, Input in, Battlefield bf, ShipFiller sf, Player player, ShipServices ss) {

        // A-J, 1-10; h/v; 1-4
        // B, 4; H; 3
        String[] chunks = inputString.split(";");

        if (chunks.length == 1 && ("auto".equals(inputString) ||"авто".equals(inputString))) {
            in.getListener().autoFill(bf, sf, player, ss);
        }

        ShipDeckCount dc = ShipDeckCount.valueOf(in.getCurrentShipDeck());

        if (chunks.length >= 1) {
            Point c = parseCoords(chunks[0]);
            Orientation orient = Orientation.None;
            if (in.getCurrentShipDeck() == 1) {
                orient = Orientation.Horizontal;
            } else if ("H".equals(chunks[1]) || "h".equals(chunks[1])) {
                orient = Orientation.Horizontal;
            } else if ("V".equals(chunks[1]) || "v".equals(chunks[1])) {
                orient = Orientation.Vertical;
            }

            if (orient != Orientation.None && c.getX() >= 0 && c.getY() >= 0) {
                if (!in.getListener().addNewShip(dc, orient, new Point(c.getX(), c.getY()))) {
                    in.setCurrentShipDeckImplements(); //Тут тоже какие-то новщества использовал может не увеличиваться
                    updateMessage(in,inputString, bf, sf, player, ss);
                }
            }
        }
    }

    private void doProcess(String inputString, Input in) {

        Point c = parseCoords(inputString);

        if (c.getX() >= 0 && c.getY() >= 0) {
            in.getListener().attack(c.getX(), c.getY());
        }
    }
}
