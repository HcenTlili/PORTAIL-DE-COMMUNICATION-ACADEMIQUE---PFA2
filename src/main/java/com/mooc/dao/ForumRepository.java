package com.mooc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mooc.entities.Cours;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Forum;

@Repository
//RestResource(collectionResourceRel="cours" , path="cours")
public interface ForumRepository extends MongoRepository<Forum, String> {

	@Query("{ 'nomCours' : ?0 }")
	public Forum findForumByName( String mc);
}



