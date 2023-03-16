package com.example.cricketgame.Repositories;

import com.example.cricketgame.Entities.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MatchRepository extends MongoRepository<Match, String> {
    Optional<Match> findByMatchId(String s);
}
