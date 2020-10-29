package com.him.github.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Roller class is maintaining the order of Players,
 * and have logic of rolling dice and maintaining points of Player
 */
public class Roller {

    // Map with key as Order Number and value as Player
    private Map<Integer, Player> orderMap = new HashMap<>();
    //Total players playing in a game
    private Integer totalPlayers;
    //Least Points to accumulate by a Player to finish game
    private Integer maxPoints;
    //Initialize RankTable to maintain ranking of Players
    RankTable rankTable = new RankTable();

    public Roller(int players, int maxPoints) {
        this.totalPlayers = players;
        this.maxPoints = maxPoints;
    }

    public Map<Integer, Player> getOrderMap() {
        return orderMap;
    }

    /**
     * Adding player to Order Map and Ranking Table
     * @param order
     * @param player
     */
    public void addPlayer(Integer order, Player player) {
        this.orderMap.put(order, player);
        rankTable.addPlayer(player);
    }

    /**
     * Main Function to process game proceedings
     */
    public void startGame() {
        int order = 1;
        while (orderMap.size() != 0) {
            Player player = orderMap.get(order);
            if (player != null) {
                dice(player, order);
            }
            order = incOrder(order);
        }
    }

    private int incOrder(int order) {
        if (order == totalPlayers) {
            return 1;
        }
        return ++order;
    }

    private void dice(Player player, int order) {
        int lastDicePt = player.getLastPoint();
        //Check if player is in penalised state or not
        if (player.getInPenalty()) {
            System.out.println(player.getPlayerName() + " is penalised due to last two consecutive 1s. This chance is skipped for you.");
            player.setInPenalty(false);
            player.setLastPoint(0);
            return;
        }

        //Rolling Dice
        System.out.println(player.getPlayerName() + " its your turn (press ‘r’ to roll the dice)");
        Scanner in = new Scanner(System.in);
        in.next();
        int diceCount = RandomGeneratorUtil.getRandom(6);
        player.addPoints(diceCount);
        if (checkEndState(player, order))
            return;

        //Set penalty for player if two consecutive 1s
        if (diceCount == 1 && lastDicePt == 1) {
            player.setInPenalty(true);
        }

        // Provide chance to same player again if Dice comes 6
        while (diceCount == 6) {
            System.out.println("You got another chance.(press ‘r’ to roll the dice again)");
            in.next();
            diceCount = RandomGeneratorUtil.getRandom(6);
            player.addPoints(diceCount);
            if (checkEndState(player, order))
                return;
        }
    }

    /**
     * Check end state of Player. IF reached, then remove it from orderMap
     * as it no longer need of dice roll for that player.
     * Also, call finishStage method of RankTable so its state can be fixed.
     * @param player
     * @param order
     * @return
     */
    private boolean checkEndState(Player player, int order) {
        if (player.getPoints() >= maxPoints) {
            System.out.println(player.getPlayerName() + " has finished the game. Your ranking : "
                    + rankTable.finishStage(player));
            orderMap.remove(order);
            rankTable.displayRankTable();
            return true;
        } else {
            rankTable.displayRankTable();
            return false;
        }

    }

    public void printOrder() {
        System.out.print("Players in Order: ");
        for(int i=1 ; i<=totalPlayers;i++) {
            Player player = orderMap.get(i);
            if(player !=null) {
                System.out.print(player.getPlayerName() + " ");
            }
        }
        System.out.println();
    }

}
