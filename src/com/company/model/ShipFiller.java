package com.company.model;

import com.company.util.services.BasePlayerService;

public class ShipFiller {

    private BasePlayerService player;

    public ShipFiller(BasePlayerService player) {
        this.player = player;
    }

    public BasePlayerService getPlayer() {
        return player;
    }

    public void setPlayer(BasePlayerService player) {
        this.player = player;
    }

}
