package com.example.cricketgame.Entities;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players") @AllArgsConstructor
@Data
@NoArgsConstructor
public class Player {
    @Id
    private String id;
    private String name;
    private String team;
    private PlayerTitle title;
    @Transient
    private int battingRuns=0;

    public void addRuns(int runs){
        this.battingRuns+=runs;
    }

    private int bowlingWickets=0;
    public void addWicket(){
        bowlingWickets++;
    }
    @Transient
    private int foursScored = 0;

    public void addFour() {
        foursScored++;
    }

    @Transient
    private int sixesScored = 0;

    public void addSix() {
        sixesScored++;
    }

}
