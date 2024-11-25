package com.dijo.tourmanager.repositories;


import com.dijo.tourmanager.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String>{

    
}
