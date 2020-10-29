package com.him.github.game;

import java.util.Objects;

/**
 * Player class contains player details .
 * It implements Comparable interface which compares
 * on the basis of their points accumulated.
 */
public class Player implements Comparable {
    // Player name- unique for every player
    private String playerName;
    //Total points accumulated
    private Integer points;
    //Player rank
    private Integer rank;
    //If player is in penalty state or not.
    private Boolean inPenalty;
    //It contains last dice point came for this player.
    private Integer lastPoint;

    public Player(int pl) {
        this.playerName = "Player-" + pl;
        points = 0;
        rank = pl;
        lastPoint = 0;
        inPenalty = false;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setLastPoint(Integer lastPoint) {
        this.lastPoint = lastPoint;
    }

    public void setInPenalty(Boolean inPenalty) {
        this.inPenalty = inPenalty;
    }


    public Integer getLastPoint() {
        return lastPoint;
    }

    public Boolean getInPenalty() {
        return inPenalty;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getPoints() {
        return points;
    }

    public void addPoints(Integer pts) {
        System.out.println("Dice got : " + pts);
        points += pts;
        lastPoint = pts;
        //return points;
    }

    public Integer getRank() {
        return rank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerName.equals(player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", points=" + points +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        //return this.points.compareTo(((Player)o).getPoints());
        return ((Player) o).getPoints().compareTo(this.points);
    }
}
