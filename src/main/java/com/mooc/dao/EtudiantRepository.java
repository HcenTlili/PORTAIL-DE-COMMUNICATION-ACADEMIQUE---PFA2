package com.mooc.dao;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import com.mooc.entities.Etudiant;
import com.mooc.entities.user;

@Repository
//RestResource(collectionResourceRel="etudiant" , path="etudiant")
public interface EtudiantRepository extends MongoRepository<Etudiant, String>{
	
	@Query(value="{'idClasse' : ?0}")
	List<Etudiant> findUsersParClasseId(String idClasse);
	
	@Query("{ 'username' : ?0 }")
	public Etudiant findByUserName( String mc);

	
}
