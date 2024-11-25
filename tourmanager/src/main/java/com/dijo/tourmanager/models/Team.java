package com.dijo.tourmanager.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Document(collection = "teams")
@Accessors(chain = true)
@Data
@Getter
@Setter
public class Team extends BaseModel {

    @Indexed(unique = true)
    @Field
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z0-9 ]")
    private String name;

    @Field
    @Indexed(unique =  true)
    @Size(min = 3, max = 7)
    private String acronym;

    @Pattern(regexp = "[a-zA-Z0-9 ]")
    private Address address;


    @DBRef
    private Set<Player> players;


    public Team () {
        this.players = new HashSet<>();
    }
}
