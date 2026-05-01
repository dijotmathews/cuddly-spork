package com.coredata.backend.repository;

import com.coredata.backend.entity.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {
     Slice<Event> findAllBy(Pageable pageable);
}
