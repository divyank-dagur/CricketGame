package com.example.cricketgame.transformer;


import com.example.cricketgame.Entities.Match;
import com.example.cricketgame.dto.MatchDTO;

public class MatchTransformer {
    public static MatchDTO matchToDTO(Match match){
        MatchDTO matchDTO=new MatchDTO();
        matchDTO.setMatchId(match.getMatchId());
        matchDTO.setTeam1Id(match.getTeam1Id());
        matchDTO.setTeam2Id(match.getTeam2Id());
        matchDTO.setTeam1Score(match.getTeam1Score());
        matchDTO.setTeam2Score(match.getTeam2Score());
        return matchDTO;
    }
    public static Match DTOToMatch(MatchDTO matchDTO){
        Match match=new Match();
        match.setMatchId(matchDTO.getMatchId());
        match.setTeam1Id(matchDTO.getTeam1Id());
        match.setTeam2Id(matchDTO.getTeam2Id());
        match.setTeam1Score(matchDTO.getTeam1Score());
        match.setTeam2Score(matchDTO.getTeam2Score());
        return match;
    }
}
