package com.coredata.backend.repository;

import com.coredata.backend.entity.Tournament;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TournamentRepository extends JpaRepository<Tournament, Long>, JpaSpecificationExecutor<Tournament> {
    Slice<Tournament> findAllBy(Pageable pageable);
}
