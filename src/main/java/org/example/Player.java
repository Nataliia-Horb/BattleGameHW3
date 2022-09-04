package org.example;

import lombok.Data;

@Data
public abstract class Player implements GameConstants  {
    private String name;
    private int health;
    private int superPower;
    private boolean isLossHealth;

    private boolean isNewSuperPower;
    private boolean isEffectiveBlow;

    public Player(String name, int superPower) {
        this.name = name;
        this.health = PLAYER_HEALTH_AT_START;
        this.superPower = superPower;
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

    public abstract void hitEnemy();
}
