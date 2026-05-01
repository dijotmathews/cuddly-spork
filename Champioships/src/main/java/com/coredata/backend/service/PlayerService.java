package com.coredata.backend.service;

import com.coredata.backend.dto.PlayerListItem;
import com.coredata.backend.entity.Player;
import com.coredata.backend.repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public void createPlayer(String firstname, String lastname, LocalDate dob) {
    }

    @Transactional(readOnly = true)
    public Page<PlayerListItem> getPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable)
                .map(this::toListItem);
    }

    @Transactional(readOnly = true)
    public Page<PlayerListItem> findPlayers(Pageable pageable, String name) {
        return playerRepository.findAllByNameContainingIgnoreCase(name, pageable)
                .map(this::toListItem);
    }

    private PlayerListItem toListItem(Player player) {
        return new PlayerListItem(
                player.getId(),
                player.getName(),
                player.getDob()
        );
    }
}
