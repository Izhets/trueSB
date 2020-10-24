package com.company.util;

public enum ShipDeckCount {

    invalid(-1), One(1), Two(2), Three(3), Four(4);

    private final int value;
    private static ShipDeckCount[] map;

    static {
        map = new ShipDeckCount[5];
        int counter = 0;
        for (ShipDeckCount d : ShipDeckCount.values()) {
            map[counter++] = d;
        }
    }

    ShipDeckCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ShipDeckCount valueOf(int i) {

        if (i >= 0 && i < 5) {
            return map[i];
        }

        return invalid;
    }
}
