package com.dijo.tourmanager;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
import lombok.experimental.Accessors;

@Document(collection = "teams")
@Accessors(chain = true)
@Data
public class Team {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Indexed(unique = true)
    @Field
    private String name;

    @Field
    @Indexed(unique =  true)
    private String acronym;

    private Address address;
    private Date createdAt;
    private Date updatedAt;

    @DBRef
    private Set<Player> players;


    public Team () {
        this.players = new HashSet<>();
    }
}
