package com.example.cricketgame.Utility;


import com.example.cricketgame.Entities.Player;
import com.example.cricketgame.Entities.PlayerTitle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PlayingOrder {
    private List<Player> playerOrder;

    public List<Player> battingOrder(List<Player> playerList) {
        playerOrder = new ArrayList<>();
        addToList(PlayerTitle.STRONG_BATSMAN, playerList);
        addToList(PlayerTitle.ALL_ROUNDER, playerList);
        addToList(PlayerTitle.AVERAGE_BATSMAN, playerList);
        addToList(PlayerTitle.STRONG_BOWLER, playerList);
        addToList(PlayerTitle.AVERAGE_BOWLER, playerList);
        return playerOrder;
    }

    public List<Player> bowlingOrder(List<Player> playerList) {
        playerOrder = new ArrayList<>();
        addToList(PlayerTitle.STRONG_BOWLER, playerList);
        addToList(PlayerTitle.ALL_ROUNDER, playerList);
        addToList(PlayerTitle.AVERAGE_BOWLER, playerList);
        return playerOrder;
    }

    private void addToList(PlayerTitle playerTitle, List<Player> playerList) {
        for (Player player : playerList) {
            if (player.getTitle() == playerTitle) {
                playerOrder.add(player);
            }
        }
    }
}
