package org.example;

/*
Участвует два игрока. У каждого игрока изначально 100 очков здоровья.
Игра начинается с бросания жребия: если сгенерированное псевдослучайное число меньше 0,5 - первый удар наносит первый
 игрок, в противном случае - второй.****

Игроки наносят удары по очереди. Если значение сгенерированного псевдослучайного числа не превышает 0,4, то удар игрока
достиг противника. При попадании по противнику противник теряет 10 очков здоровья.**

Каждый из игроков обладает суперсилой, позволяющей в случае точного удара противника отбить этот удар, не потеряв очков
 здоровья, но уменьшив количество суперсилы на единицу. Изначально у каждого игрока по 3 единицы суперсилы. Единицы
 суперсилы можно заработать нанеся 2 точных удара по противнику в свой ход подряд. Зв каждый раз, нанеся ровно два
 точных удара подряд - добьавляется одна едница суперсилы. 2 раза подряд точно попали - плюс один к суперсиле, 4 раза
 попали - плюс 2 к суперсиле.

При попадании по противнику, в случае уменьшения его очков здоровья, сцена окрашивается в цвет игрока, нанесшего точный
 удар (текстовый вывод в консоль). При завершении игры выводится текст «Победил + имя игрока».

В ходе игры ведется статистика. В конце игры необходимо вывести общее количество ударов игроков, количество точных
 ударов каждого из игроков, количество приобретенных в ходе игры суперсил, не считая начальное количество.

Игра завершается, когда количество очков здоровья одного из игроков достигнет 0.

First level: Модифицировать код реализации поставленной в прошлый раз задачи со следующими изменениями:
Существует два типа игрока:
У первого типа игрока изначально количество единиц суперсилы равно 5, но для получения новой единицы суперсилы необходимо нанести 3 точных удара в свой ход подряд.
У игрока второго типа изначально 3 единицы суперсилы, но для получения новой единицы суперсилы необходимо нанести 2 точных удара по сопернику в в свой ход подряд.
В каждой игре один из игроков - игрок типа 1, а второй типа 2 (игроки в рамках одной игры всегда разных типов).
Реализовать два различных класса для двух типов игроков, используя наследования от базового класса игрока.


*/
public class Game implements GameConstants {
    private static int numberOfTotalHitsPlayers;

    public static void main(String[] args) {

        Player player1 = new PlayerType1("Gladiator");
        Player player2 = new PlayerType2("Night Racer");
        Statistics statisticsPlayer1 = new Statistics();
        Statistics statisticsPlayer2 = new Statistics();
        Stage stage = new Stage();
        play(player1, player2, statisticsPlayer1, statisticsPlayer2, stage);
    }

    public static void play(Player player1, Player player2, Statistics statisticsPlayer1,
                            Statistics statisticsPlayer2, Stage stage) {

        if (Math.random() < 0.5) {
            makeGame(player1, player2, statisticsPlayer1, statisticsPlayer2, stage);
        } else {
            makeGame(player2, player1, statisticsPlayer2, statisticsPlayer1, stage);
        }
    }

    private static void makeOneHit(Player player1, Player player2, Statistics statisticsPlayer1,
                                   Statistics statisticsPlayer2, Stage stage, String color) {
        player1.hitEnemy();
        statisticsPlayer1.count(player1);
        numberOfTotalHitsPlayers++;
        player2.blowResponse(player1);
        stage.drawColor(player1, color);

        // Вывод на экран результатов боя пошагово, для самопроверки
        statisticsPlayer1.printStatistics(player1);
        statisticsPlayer2.printHealthAndSuperPower(player2);

    }

    private static void makeGame(Player player1, Player player2, Statistics statisticsPlayer1,
                                 Statistics statisticsPlayer2, Stage stage) {
        do {
            makeOneHit(player1, player2, statisticsPlayer1, statisticsPlayer2, stage, COLOR_PLAYER1);
            makeOneHit(player2, player1, statisticsPlayer2, statisticsPlayer1, stage, COLOR_PLAYER2);
        }
        while (player1.getHealth() > 0 && player2.getHealth() > 0);
        printGameResultsNotification(player1, player2, statisticsPlayer1, statisticsPlayer2, stage);
    }

    private static void printGameResultsNotification(Player player1, Player player2, Statistics statisticsPlayer1,
                                                     Statistics statisticsPlayer2, Stage stage) {
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * * ");
        if (player1.getHealth() <= 0) {
            stage.victoryNotification(player2.getName());
        } else {
            stage.victoryNotification(player1.getName());
        }

        System.out.println(numberOfTotalHitsPlayers + " Hits in total per Game");
        statisticsPlayer1.printStatistics(player1);
        statisticsPlayer2.printStatistics(player2);
    }


}