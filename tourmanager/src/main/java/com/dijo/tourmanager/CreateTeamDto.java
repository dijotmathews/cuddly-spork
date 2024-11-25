package com.dijo.tourmanager;

import com.dijo.tourmanager.models.Address;
import com.dijo.tourmanager.models.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTeamDto {
    // @NotNull(message = "Team name is needed.")
    // @NotEmpty(message = "Team name cannot be empty")
    private String name;


    // @Size(min = 3, max = 5, message = "Acronym needs to be 3 to 5 characters long")
    private String acronym;
  
    // @NotEmpty(message = "Team address cannot be empty")
    private Address address;
  
    public Team toTeam() {
      return new Team().setName(name).setAcronym(acronym).setAddress(address);
    }
}
