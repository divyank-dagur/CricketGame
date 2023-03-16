package com.example.cricketgame.Repositories;

import com.example.cricketgame.Entities.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
}
