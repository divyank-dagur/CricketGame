package com.example.cricketgame.Controllers;


import com.example.cricketgame.Repositories.TeamRepository;
import com.example.cricketgame.Services.TeamService;
import com.example.cricketgame.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.cricketgame.transformer.TeamTransformer.DTOToTeam;
import static com.example.cricketgame.transformer.TeamTransformer.teamToDTO;


@RestController
@RequestMapping("/team")
public class TeamAPI {

    @Autowired
    public TeamService teamService;
    @Autowired
    public TeamRepository teamRepo;

    @PostMapping
    public TeamDTO addTeam(@RequestBody TeamDTO teamDTO) {
        return teamToDTO(teamService.addTeam(DTOToTeam(teamDTO)));
    }

    @GetMapping
    public List<TeamDTO> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/{teamId}")
    public TeamDTO getTeam(@PathVariable String teamId) {
        try {
            return teamToDTO(teamService.getTeam(teamId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
