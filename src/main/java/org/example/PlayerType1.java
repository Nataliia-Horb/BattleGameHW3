package org.example;

public class PlayerType1 extends Player implements PlayerLogic {
    private int effectiveBlowsCounter;
    private int limitForOneNeuSuperpower;


    public PlayerType1(String name) {
        super(name, PLAYER1_SUPER_POWER_AT_START);
        limitForOneNeuSuperpower = PLAYER1_LIMIT_FOR_NEU_SUPERPOWER;
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
