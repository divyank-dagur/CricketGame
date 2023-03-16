package com.example.cricketgame.Repositories;

import com.example.cricketgame.Entities.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player,String> {

}
