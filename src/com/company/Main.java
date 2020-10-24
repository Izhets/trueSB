package com.company;

import com.company.model.*;
import com.company.util.GameStatus;
import com.company.util.InputListener;
import com.company.util.services.BasePlayerService;
import com.company.util.services.BattlefieldService;
import com.company.util.services.GameServices;
import com.company.util.services.InputServices;

public class Main {
    Player player;
    Game game;
    BasePlayerService bps;
    InputListener listener;
    InputServices is;
    Battlefield bf;
    Point p;
    GameStatus state;
    InputServices inS;
    Input in;

    public static void main(String[] args) {


        GameServices gameS = new GameServices();

        do {
            gameS.process(game, bf, player, p, state, inS, in);
            } while (!game.isGameOver(game));
        }
    }

