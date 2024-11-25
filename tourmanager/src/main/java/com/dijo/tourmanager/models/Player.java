package com.dijo.tourmanager.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "players")
@Accessors(chain = true)
@NoArgsConstructor
@Data
@Getter
@Setter
public class Player extends BaseModel{

    @Indexed
    private String name;

//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date birthDate;

//    @Indexed
//    @Field(targetType = FieldType.STRING)

    private boolean isAvailable;


}
