package com.coredata.backend.service;


import com.coredata.backend.entity.Tournament;
import com.coredata.backend.entity.Venue;
import com.coredata.backend.repository.TournamentRepository;
import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Transactional
    public void createTournament(String name, Set<Venue> venues, LocalDate startDate, @Nullable LocalDate endDate ) {
    }

    @Transactional(readOnly = true)
    public List<Tournament> list(Pageable pageable) {
        return tournamentRepository.findAll();
    }

    @PostConstruct
    public void populateTestData() {
        if (tournamentRepository.count() == 0) {
            tournamentRepository.saveAll(new ArrayList<>(List.of(
                    new Tournament("Spring Championship", LocalDate.now().plusDays(14), LocalDate.now().plusDays(16)),
                    new Tournament("Summer Open", LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(2).plusDays(3)),
                    new Tournament("Autumn Invitational", LocalDate.now().plusMonths(5), null)
            )));
        }
    }
}
