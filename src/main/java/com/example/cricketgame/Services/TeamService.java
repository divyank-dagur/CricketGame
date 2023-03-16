package com.example.cricketgame.Services;


import com.example.cricketgame.Entities.Team;
import com.example.cricketgame.Repositories.TeamRepository;
import com.example.cricketgame.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.cricketgame.Counter.counter;
import static com.example.cricketgame.transformer.TeamTransformer.teamToDTO;


@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepo;
    public Team getTeamBYId(String teamId) throws Exception{
        Optional<Team> teamOptional = teamRepo.findById(teamId);
        if (teamOptional.isPresent()) {
           counter++;
            return teamOptional.get();
        }
        else {
            throw new Exception("Invalid teamId!");
        }
    }
    public Team addTeam(Team team) {
        return teamRepo.save(team);
    }
    public List<TeamDTO> getTeams(){
        List<TeamDTO> teamDTOs=new ArrayList<>();
        List<Team> teams=teamRepo.findAll();
        for (Team team:teams
             ) {
            teamDTOs.add(teamToDTO(team));
        }
        return teamDTOs;
    }

    public Team getTeam(String teamId) throws Exception{
        if(teamRepo.findById(teamId).isPresent()) return teamRepo.findById(teamId).get();
        else throw new Exception("team with teamId - "+teamId+"doesn't exist");
    }
}
