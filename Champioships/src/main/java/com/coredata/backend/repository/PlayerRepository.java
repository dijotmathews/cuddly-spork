package com.coredata.backend.repository;

import com.coredata.backend.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlayerRepository extends JpaRepository<Player, Long>, JpaSpecificationExecutor<Player> {
    Page<Player> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
