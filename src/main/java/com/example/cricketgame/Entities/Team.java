package com.example.cricketgame.Entities;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Team")
public class Team {
    @Id
    private String id;
    private String name;
    private List<String> teamPlayerIds;

    @Transient
    private int teamRuns = 0;

    public void addRuns(int runs) {
        this.teamRuns += runs;
    }
}
