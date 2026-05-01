package com.coredata.backend.seed;

import com.coredata.backend.entity.Player;
import com.coredata.backend.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(10)
public class PlayerSeeder implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    public PlayerSeeder(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (playerRepository.count() > 0) {
            return;
        }

        playerRepository.saveAll(List.of(
                new Player("Aarav Sharma", LocalDate.of(1998, 3, 14)),
                new Player("Mia Thompson", LocalDate.of(2001, 7, 9)),
                new Player("Luca Rossi", LocalDate.of(1996, 11, 22)),
                new Player("Sofia Martinez", LocalDate.of(2000, 1, 30))
        ));
    }
}
