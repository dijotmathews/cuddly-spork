package com.dijo.tourmanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    TeamRepository teamRepository;
    
    PlayerRepository playerRepository;

    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@Validated @RequestBody CreateTeamDto createTeamDto) {
        Team teamCreated = teamRepository.save(createTeamDto.toTeam());

        return new ResponseEntity<>(teamCreated, HttpStatus.CREATED);
    }
}
