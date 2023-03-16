package com.example.cricketgame.Repositories;

import com.example.cricketgame.Entities.MatchStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchStatsRepository extends MongoRepository<MatchStats,String> {
}
