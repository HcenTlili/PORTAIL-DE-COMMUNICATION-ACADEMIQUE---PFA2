package com.mooc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.mooc.entities.Enseignant;
import com.mooc.entities.Etudiant;

@Repository
//RestResource(collectionResourceRel="enseignant" , path="enseignant")
public interface EnseignantRepository extends MongoRepository<Enseignant, String>{
	
	@Query("{ 'username' : ?0 }")
	public Enseignant findByUserName( String mc);
}
