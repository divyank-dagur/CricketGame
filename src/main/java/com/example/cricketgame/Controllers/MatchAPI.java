package com.example.cricketgame.Controllers;

import com.example.cricketgame.Entities.Match;
import com.example.cricketgame.Services.MatchService;
import com.example.cricketgame.Services.MatchStatsService;
import com.example.cricketgame.Services.PlayerService;
import com.example.cricketgame.Services.TeamService;
import com.example.cricketgame.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.cricketgame.transformer.MatchTransformer.DTOToMatch;
import static com.example.cricketgame.transformer.MatchTransformer.matchToDTO;


@RestController
@RequestMapping("/match")
public class MatchAPI {
    @Autowired
    public MatchService matchService;
    @Autowired
    public TeamService teamService; //doubt- can I use teamService in matchAPI
    @Autowired
    public PlayerService playerService;//same doubt as above
    @Autowired
    public MatchStatsService matchStatsService;

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        return matchService.addMatch(match);
    }
    @GetMapping
    public List<MatchDTO> getMatches() {
        List<MatchDTO> matchDTOs = new ArrayList<>();
        List<Match> matches = matchService.getMatches();
        for (Match match : matches) {
            matchDTOs.add(matchToDTO(match));
        }
        return matchDTOs;
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<Object> getTeamDetails(@PathVariable String matchId) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(matchService.getTeamDetails(matchId));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/matchStats/{matchId}")
    public ResponseEntity<Object> getMatchStats(@PathVariable String matchId) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(matchStatsService.findMatchStatsById(matchId));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/start/{matchId}")
    public String startMatch(@PathVariable(value = "matchId") String matchId) throws Exception {

            return matchService.startMatch(matchId);

    }
}
