package com.him.github.game;

import java.util.Map;

public class GameOfDice {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide N(Number of players) and M(Points to accumulate) as Integers in command line args consecutively.\n"
                    + "Ex: java GameOfDice 4 20");
            System.exit(0);
        }
        int N = 0, M = 0;
        try {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Please provide N(Number of players) and M(Points to accumulate) as Integers in command line args consecutively.\n"
                    + "Ex: java GameOfDice 4 20");
            System.exit(0);
        }

        initiate(N, M);
    }

    /**
     * Initiate Roller class by creating players and assigning their order randomly
     * @param players
     * @param maxPoints
     */
    private static void initiate(int players, int maxPoints) {
        Roller roller = new Roller(players, maxPoints);
        for (int i = 1; i <= players; i++) {
            Player player = new Player(i);
            roller.addPlayer(RandomGeneratorUtil.getRandom(players, roller.getOrderMap()), player);
        }

        roller.printOrder();
        System.out.println("*=*==*=*=*=*=*=*==*=*=*=*=Let's start the Game*=*==*=*=*=*==*=*=*=*==*=*=");
        //Start Game
        roller.startGame();
        System.out.println("*=*==*=*=*=*=*=*==*=*=*=*=Game End*=*==*=*=*=*==*=*=*=*==*=*=*");
    }


}
