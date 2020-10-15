package com.mestresistemico.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mestresistemico.workshopmongo.domain.User;

@Repository
public interface UserRepository extends /* Exclusivo Mongo */ MongoRepository<User, String>{

}
