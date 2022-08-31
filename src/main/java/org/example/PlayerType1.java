package org.example;


public class PlayerType1 extends Player implements GameConstants {

    public PlayerType1(String name) {
        super(name, PLAYER1_SUPER_POWER_AT_START, PLAYER1_LIMIT_FOR_NEU_SUPERPOWER);
    }


}
