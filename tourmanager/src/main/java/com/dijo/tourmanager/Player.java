package com.dijo.tourmanager;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Document(collection = "players")
@Accessors(chain = true)
@NoArgsConstructor
@Data
public class Player {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Indexed
    private String name;

    private Date dob;

    @Indexed
    @Field(targetType = FieldType.STRING)

    private boolean isAvailable;

    private Date createdAt;

    private Date updatedAt;
}
