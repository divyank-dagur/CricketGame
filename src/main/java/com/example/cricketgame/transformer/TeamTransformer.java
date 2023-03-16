package com.example.cricketgame.transformer;


import com.example.cricketgame.Entities.Team;
import com.example.cricketgame.dto.TeamDTO;

public class TeamTransformer {
    public static Team DTOToTeam(TeamDTO teamDTO){
        Team team=new Team();
        team.setId(teamDTO.getId());
        team.setTeamPlayerIds(teamDTO.getTeamPlayerIds());
        team.setName(teamDTO.getName());
        return team;
    }
    public static TeamDTO teamToDTO(Team team){
        TeamDTO teamDTO=new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setTeamPlayerIds(team.getTeamPlayerIds());
        return teamDTO;
    }
}
