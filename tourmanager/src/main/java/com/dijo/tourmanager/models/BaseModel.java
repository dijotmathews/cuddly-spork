package com.dijo.tourmanager.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
public class BaseModel {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private Date createdAt;
    private Date updatedAt;


}
