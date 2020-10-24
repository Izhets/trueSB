package com.company.model;

import com.company.util.IBattlefield;

public class Battlefield {

//    public Battlefield () {
//        //Размеры поля
//        final int Width = 10;
//        final int Height = 10;
//
//        //Ячейка
//        //public char[] title = new char[Width];
//        char[] title = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
//        char[][] cells = new char[Width][Height];
//
//        //Динамический массив из объектов
//        IBattlefield[][] objects = new IBattlefield[Width][Height];
//        Point[] neighbours;
//    }

    //Размеры поля
    private final int Width = 10;
    private final int Height = 10;

    //Ячейка
    //public char[] title = new char[Width];
    private char[] title = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private char[][] cells = new char[Width][Height];

    //Динамический массив из объектов
    private IBattlefield[][] objects = new IBattlefield[Width][Height];
    private Point[] neighbours;

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    public char[] getTitle() {
        return title;
    }

    public char[][] getCells() {
        return cells;
    }

    public IBattlefield[][] getObjects() {
        return objects;
    }

    public Point[] getNeighbours(){
        neighbours = new Point[8];
        neighbours[0] = new Point(-1, -1);
        neighbours[1] = new Point(-1, 0);
        neighbours[2] = new Point(-1, 1);
        neighbours[3] = new Point(0, 1);
        neighbours[4] = new Point(1, 1);
        neighbours[5] = new Point(1, 0);
        neighbours[6] = new Point(1, -1);
        neighbours[7] = new Point(0, -1);

        return neighbours;
    }
}
