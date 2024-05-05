package eus.birt.dam.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Museos;

public interface MuseoRepository extends MongoRepository<Museos, String>{
	
}
