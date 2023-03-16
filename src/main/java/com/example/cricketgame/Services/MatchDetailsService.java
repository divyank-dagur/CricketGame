package com.example.cricketgame.Services;


import com.example.cricketgame.Entities.Match;
import com.example.cricketgame.Repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.cricketgame.Counter.counter;


@Service
public class MatchDetailsService {
    @Autowired
    MatchRepository matchRepo;
    public void updateTeamScoreMatchDetails(String matchId, String teamId, int teamScore){
        Match match = matchRepo.findById(matchId).get();
        counter++;
        if(match.getTeam1Id()==teamId)
            match.setTeam1Score(teamScore);
        else
            match.setTeam2Score(teamScore);

        matchRepo.save(match);
        counter++;
    }

    public Match findMatchDetailsById(String matchId){
        Match match;
        if(matchRepo.findById(matchId).isPresent()){
            counter++;
            counter++;
            match = matchRepo.findById(matchId).get();
            return match;
        }
        else{
            System.out.println("matchId not found!");
            return null;
        }

    }

    public int getTeamScore(String matchId, String teamId){
        Match match = matchRepo.findById(matchId).get();
        counter++;
        if(match.getTeam1Id()==teamId)
            return match.getTeam1Score();
        else
            return match.getTeam2Score();

    }

    public void matchCompleted(String matchId){
        Match match = matchRepo.findById(matchId).get();
        match.setCompleted(true);
        matchRepo.save(match);
        counter++;
        counter++;
    }

}
