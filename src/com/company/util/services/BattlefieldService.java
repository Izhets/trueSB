package com.company.util.services;

import com.company.model.Battlefield;
import com.company.model.Deck;
import com.company.util.IBattlefield;
import com.company.model.Point;

public class BattlefieldService {

    //Отрисовка поля
    public void drawBattlefield(Battlefield bf, Point p) {
        update(bf, p);

        int coordX = 0;
        int coordY = 1;

        System.out.print(' ');
        for (int x = 0; x < bf.getWidth(); ++x) {
            System.out.print(' ');
            System.out.print(bf.getTitle()[coordX++]);
        }

        System.out.println();

        for (int y = 0; y < bf.getHeight(); ++y) {
            System.out.print(coordY++);
            for (int x = 0; x < bf.getWidth(); ++x) {
                if (!(x == 0 && coordY == 11)) {
                    System.out.print(' ');
                }
                System.out.print(bf.getCells()[x][y]);
            }
            System.out.println('|');
        }
    }

    //репаинть
    private void update(Battlefield bf, Point p) {
        clean(bf);
        for (int y = 0; y < bf.getHeight(); ++y) {
            for (int x = 0; x < bf.getWidth(); ++x) {
                IBattlefield Objects = bf.getObjects()[x][y];

                if (Objects != null) {
                    Point position = Objects.getPosition();
                    bf.getCells()[position.getX()][position.getY()] = Objects.getView();
                }
            }
        }
    }

    //очистка
    public void clean(Battlefield bf) {
        for (int y = 0; y < bf.getHeight(); ++y) {
            for (int x = 0; x < bf.getWidth(); ++x) {
                bf.getCells()[x][y] = ' ';
            }
        }
    }

    public void addObject(Battlefield bf, IBattlefield object) {
        Point position = object.getPosition();
        if (isValidCoord(bf, position)) {
            bf.getObjects()[position.getX()][position.getY()] = object;
        } else {
            //GData.log.warning("Чёто не то");
        }
    }

    //Проверка на то, что точка лежит в пределах карты
    public boolean isValidCoord(Battlefield bf, Point points) {
        return points.getX() >= 0 && points.getX()  < bf.getWidth() && points.getY() >= 0 && points.getY() < bf.getHeight();
    }

    //Проверка на пересечение
    public boolean isCollide(Battlefield bf, Point position) {
        return bf.getObjects()[position.getX()][position.getY()] != null;
    }

    //Проверка на соседей
    public boolean hasNeighbours(Battlefield bf, Point position) {

        boolean result = false;

        for (Point p : bf.getNeighbours()) {
            Point neighbour = new Point(position.getX() + p.getX(), position.getY() + p.getY());
            if (isValidCoord(bf, neighbour) && bf.getObjects()[neighbour.getX()][neighbour.getY()] != null) {
                result = true;
                break;
            }
        }

        return result;
    }

}
