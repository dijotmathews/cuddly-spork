package com.dijo.tourmanager.repositories;


import com.dijo.tourmanager.models.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String>{
    
}
