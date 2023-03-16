package com.example.cricketgame.Services;


import com.example.cricketgame.Entities.Player;
import com.example.cricketgame.Entities.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerStatsService {
    @Autowired
    private PlayerService playerService;
    public List<PlayerStats> convertPlayerIdListToPlayerStat(List<String> playerIdList){
        //Getting the playerList from ids.
        List<Player> playerList = playerService.getPlayerListFromIdList(playerIdList);

        //Method to add a player stat
        List<PlayerStats> playerStatsList = new ArrayList<>();

        for (Player player: playerList){
            playerStatsList.add(convertPlayerToPlayerStat(player));
        }

        return playerStatsList;
    }

    public PlayerStats convertPlayerToPlayerStat(Player player){
        PlayerStats playerStats = new PlayerStats();
        playerStats.setPlayerName(player.getName());
        playerStats.setPlayerId(player.getId());
        return playerStats;
    }
}
