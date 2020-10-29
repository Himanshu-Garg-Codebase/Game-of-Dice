package com.him.github.game;

import java.util.*;

/**
 * Maintains list of Players with their Rankings
 */
public class RankTable {

    //Dynamic List of Ongoing Players with their points in sorted order
    List<Player> table = new ArrayList<>();
    //List of Players who has finished their game and their ranks are decided
    List<Player> finalList = new ArrayList<>();

    public void addPlayer(Player pl) {
        table.add(pl);
    }

    /**
     * Function to display Rankings of Players
     */
    public void displayRankTable() {
        System.out.println("\t\t\tRank Table: ");
        System.out.println("\t\t\tPlayer\t" + "Points\t" + "Rank");
        int rank = 1;
        for (Player pl : finalList) {
            System.out.println("\t\t\t" + pl.getPlayerName() + "\t" + pl.getPoints() + "\t" + rank++);
        }

        Collections.sort(table);
        for (Player pl : table) {
            System.out.println("\t\t\t" + pl.getPlayerName() + "\t" + pl.getPoints() + "\t" + rank++);
        }
    }

    /**
     * Function to call when Player finishes game
     * It removes this player from dynamice table list and add it in finalList with Fixed ranking.
     * @param player
     * @return
     */
    public Integer finishStage(Player player) {
        table.remove(player);
        finalList.add(player);
        return finalList.size();
    }
}
