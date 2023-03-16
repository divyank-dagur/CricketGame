package com.example.cricketgame.Services;

import com.example.cricketgame.Entities.Player;
import com.example.cricketgame.Repositories.PlayerRepository;
import com.example.cricketgame.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.cricketgame.transformer.PlayerTransformer.playerToDTO;


@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepo;

    public Player getPlayerFromId(String playerId) {
        Player playerValue = null;
        Optional<Player> player = playerRepo.findById(playerId);
        if (player.isPresent()) {
            playerValue = player.get();
        }
        return playerValue;

    }

    public List<Player> getPlayerListFromIdList(List<String> playerIdList) {
        return playerRepo.findAllById(playerIdList);
    }

    public Player addPlayer(Player player) {
        return playerRepo.save(player);
    }

    public List<com.example.cricketgame.dto.PlayerDTO> getPlayers() {
        List<PlayerDTO> playerDTOs=new ArrayList<>();
        List<Player> players=playerRepo.findAll();
        for (Player player:players
             ) {
            playerDTOs.add(playerToDTO(player));
        }
        return playerDTOs;
    }

    public Player getPlayer(String playerId) throws Exception{
        if(playerRepo.findById(playerId).isPresent())
            return playerRepo.findById(playerId).get();
        else{
            throw new Exception("Player with playerID - "+playerId+"doesn't exist");
        }
    }
}

