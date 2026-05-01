package com.coredata.backend.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "player")
public record PlayerListItem(
        @Id Long id,
        String name,
        LocalDate dob
) {
    public static final String SORT_PROPERTY_NAME = "name";
}
