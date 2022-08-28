package org.example;

import lombok.Data;

@Data
public class Player implements GameConstants {
    private String name;
    private int health;
    private int superPower;

    private boolean isEffectiveBlow;
    private boolean isNewSuperPower;
    private boolean isLossHealth;
    private int effectiveBlowsCounter;


    public Player(String name) {
        this.name = name;
        this.health = PLAYER_HEALTH_AT_START;
        this.superPower = PLAYER_SUPER_POWER_AT_START;
        this.effectiveBlowsCounter = 0;
    }

    public void blowResponse(Player enemy) {
        if (enemy.isEffectiveBlow) {
            if (this.superPower > 0) {
                this.superPower--;
                this.isLossHealth = false;
            } else {
                this.health -= 10;
                this.isLossHealth = true;
            }
        } else {
            this.isLossHealth = false;
        }
    }

    private void countNewSuperPower() {
        if (this.effectiveBlowsCounter == 2) {
            this.effectiveBlowsCounter = 0;
            this.superPower++;
            this.isNewSuperPower = true;
        } else {
            isNewSuperPower = false;
        }
    }

    public void hitEnemy() {
        System.out.println("Hit");
        this.isEffectiveBlow = Math.random() < 0.4 ? true : false;
        if (isEffectiveBlow) {
            this.effectiveBlowsCounter++;
            countNewSuperPower();
        } else {
            this.effectiveBlowsCounter = 0;
        }
    }
}
