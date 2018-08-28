package com.mooc.dao;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mooc.entities.Etudiant;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mooc.entities.Fichier;

@Repository
//RestResource(collectionResourceRel="fichier" , path="fichier")
public interface FichierRepository extends MongoRepository<Fichier, String> {

	@Query("{ 'nomFichier' : { $regex: ?0 } }")
	public Fichier getfich( String mc);

	//public Fichier getFichierByNom(String fileName);

	//public Fichier getFichierByNom(String fileName);

	
}
