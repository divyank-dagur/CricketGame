package com.example.cricketgame.transformer;


import com.example.cricketgame.Entities.Player;
import com.example.cricketgame.dto.PlayerDTO;

public class PlayerTransformer {
    public static Player DTOToPlayer(PlayerDTO playerDTO){
        Player player=new Player();
        player.setName(playerDTO.getName());
        player.setId(playerDTO.getId());
        player.setTitle(playerDTO.getTitle());
        return player;
    }
    public static PlayerDTO playerToDTO(Player player){
        PlayerDTO playerDTO=new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setTitle(player.getTitle());
        return playerDTO;
    }
}
