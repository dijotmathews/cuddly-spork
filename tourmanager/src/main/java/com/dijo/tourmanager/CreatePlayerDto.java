package com.dijo.tourmanager;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePlayerDto {
    private String name;

    private Date birthDate;

    private boolean isAvailable;

    public Player toPlayer() {
        return new Player().setName(name).setDob(birthDate).setAvailable(isAvailable);
    }
}
