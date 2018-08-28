package com.mooc.dao;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import com.mooc.entities.Etudiant;
import com.mooc.entities.user;
import com.mooc.entities.EtudiantNonEnregistre;

@Repository
//RestResource(collectionResourceRel="etudiant" , path="etudiant")
public interface EtudiantNonEnregistreRepository extends MongoRepository<EtudiantNonEnregistre, String>{
	
	@Query(value="{'idClasse' : ?0}")
	List<EtudiantNonEnregistre> findUsersParClasseId(String idClasse);
	
	@Query("{ 'username' : ?0 }")
	public EtudiantNonEnregistre findByUserName( String mc);

	
}
