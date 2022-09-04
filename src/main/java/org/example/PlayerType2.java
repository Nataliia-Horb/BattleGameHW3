package org.example;

public class PlayerType2 extends Player implements PlayerLogic {
    private int effectiveBlowsCounter;
    private int limitForOneNeuSuperpower;

    public PlayerType2(String name) {
        super(name, PLAYER2_SUPER_POWER_AT_START);
        limitForOneNeuSuperpower = PLAYER2_LIMIT_FOR_NEU_SUPERPOWER;
    }

    @Override
    public void hitEnemy() {
        System.out.println("Hit");
        super.setEffectiveBlow((Math.random() < 0.4) ? true : false);
        if (super.isEffectiveBlow()) {
            this.effectiveBlowsCounter++;
            countNewSuperPower();
        } else {
            this.effectiveBlowsCounter = 0;
            super.setNewSuperPower(false);
        }
    }

    private void countNewSuperPower() {
        if (this.effectiveBlowsCounter == limitForOneNeuSuperpower) {
            super.setSuperPower(super.getSuperPower() + 1);
            this.effectiveBlowsCounter = 0;
            super.setNewSuperPower(true);
        } else {
            super.setNewSuperPower(false);
        }
    }
}
