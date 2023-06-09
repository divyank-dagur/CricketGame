package com.example.cricketgame.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStats {
    private String playerId;
    private String playerName;
    private int battingRuns;
    private int bowlingWickets;
    private int foursScored;
    private int sixesScored;
}
