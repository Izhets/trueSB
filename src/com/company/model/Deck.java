package com.company.model;

import com.company.util.IBattlefield;

public class Deck implements IBattlefield {

    private Point position;
    private char aliveView, deadView;
    private boolean isAlive;

    public Deck(Point position, char aliveView, char deadView) {

        this.position = position;
        this.aliveView = aliveView;
        this.deadView = deadView;
        isAlive = true;

    }

    public boolean isAlive() {
        return isAlive;
    }

    public Point getPosition() {
        return position;
    }

    public char getView() {
        return isAlive ? aliveView : deadView;
    }
}
