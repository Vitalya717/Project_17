package ru.netology.statistic;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> nameList = new ArrayList<>();

    public void register(Player player) {
        nameList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : nameList) {
            if (player.getName() == playerName1) {
                player1 = player;
            }
            if (player.getName() == playerName2) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
