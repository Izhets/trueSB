package com.company.model;

public class Point {

    private Point position;
    private char aliveView, deadView;
    private boolean isAlive;

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
