package com.dijo.tourmanager;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.dijo.tourmanager.models.Player;
import com.dijo.tourmanager.models.Team;
import com.dijo.tourmanager.repositories.PlayerRepository;
import com.dijo.tourmanager.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
public class TeamController {
    @Autowired
    TeamRepository teamRepository;
    
    @Autowired
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

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }


    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable String id, @RequestBody CreateTeamDto createTeamDto) {
        Optional<Team> optionalTeam = teamRepository.findById(id);


        if(optionalTeam.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        Team teamToUpdate = optionalTeam.get()
                .setAddress(createTeamDto.getAddress())
                .setName(createTeamDto.getName())
                .setAcronym(createTeamDto.getAcronym());


        Team teamUpdated = teamRepository.save(teamToUpdate);

        return new ResponseEntity<>(teamUpdated , HttpStatus.OK);

    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String id){
        teamRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/teams/{id}/players")
    public ResponseEntity<Team> addPlayersToTeam(@PathVariable String id, @RequestBody List<String> playerIds) {
        Optional<Team> optionalTeam = teamRepository.findById(id);

        if(optionalTeam.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        Team teamToUpdate = optionalTeam.get();

        Set<Player> playersToAdd = playerIds.stream()
                .map(playerId -> playerRepository.findById(playerId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        
        teamToUpdate.setPlayers(playersToAdd);

        Team teamUpdated = teamRepository.save(teamToUpdate);

        return new ResponseEntity<>(teamUpdated, HttpStatus.OK);
    }

    @PostMapping("/players")
    public ResponseEntity<Player> createPlayer(@Validated @RequestBody CreatePlayerDto createPlayerDto) {
        Player playerCreated = playerRepository.save(createPlayerDto.toPlayer());
        return new ResponseEntity<Player>(playerCreated,  HttpStatus.CREATED);
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

//    @GetMapping("/teams/{id}")

}
