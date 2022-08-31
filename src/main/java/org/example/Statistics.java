package org.example;

import lombok.Data;

@Data
public class Statistics {
    private int numberOfEffectiveHitsPlayer;
    private int numberNewSuperPowerPlayer;

    public void count(Player player) {
        if (player.isEffectiveBlow()) {
            numberOfEffectiveHitsPlayer++;
        }
        if (player.isNewSuperPower()) {
            numberNewSuperPowerPlayer++;
        }
    }


    public void printStatistics(Player player) {
        System.out.println("Effective Hits of " + player.getName() + ": " + numberOfEffectiveHitsPlayer);
        System.out.println("New Super Power of " + player.getName() + ": " + numberNewSuperPowerPlayer);
    }

    public void printHealthAndSuperPower(Player player) {
        System.out.println("Health of " + player.getName() + ": " + player.getHealth());
        System.out.println("SuperPower of " + player.getName() + ": " + player.getSuperPower());
    }
}
