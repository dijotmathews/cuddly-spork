package com.dijo.tourmanager;

import java.util.Date;

import com.dijo.tourmanager.models.Player;



public class CreatePlayerDto {
    private String name;

    private Date birthDate;

    private boolean isAvailable;

    public String getName() {
        return name;
    }


    public Player toPlayer() {
        return new Player().setName(name).setBirthDate(birthDate).setAvailable(isAvailable);
    }
}
