package org.example;

import lombok.Data;

@Data
public abstract class Player implements GameConstants {
    private String name;
    private int health;
    private int superPower;
    private int effectiveBlowsCounter;
    private int limitForOneNeuSuperpower;
    private boolean isEffectiveBlow;
    private boolean isLossHealth;
    private boolean isNewSuperPower;


    public Player(String name, int superPower, int limitForOneNeuSuperpower) {
        this.name = name;
        this.health = PLAYER_HEALTH_AT_START;
        this.superPower = superPower;
        this.limitForOneNeuSuperpower = limitForOneNeuSuperpower;
    }

    public void hitEnemy() {
        System.out.println("Hit");
        this.isEffectiveBlow = Math.random() < 0.4 ? true : false;
        if (isEffectiveBlow) {
            this.effectiveBlowsCounter++;
            countNewSuperPower();
        } else {
            this.effectiveBlowsCounter = 0;
            this.isNewSuperPower = false;
        }
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

    public void countNewSuperPower() {
        if (this.effectiveBlowsCounter == limitForOneNeuSuperpower) {
            this.superPower++;
            this.effectiveBlowsCounter = 0;
            this.isNewSuperPower = true;
        } else {
            this.isNewSuperPower = false;
        }
    }
}
