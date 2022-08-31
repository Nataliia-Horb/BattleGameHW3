package org.example;

public class Stage {

    public void drawColor(Player player, String color) {
        if (player.isLossHealth()) {
            System.out.println("The scene is colored in " + color + " color!");
        }
    }

    public void victoryNotification(String name) {
        System.out.println();
        System.out.println("Congratulations " + name + ", you won!");
    }
}
