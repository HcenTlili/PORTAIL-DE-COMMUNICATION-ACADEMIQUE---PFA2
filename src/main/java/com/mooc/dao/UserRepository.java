package com.mooc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.mooc.entities.Etudiant;
import com.mooc.entities.user;

@Repository
public interface UserRepository extends MongoRepository<user,String>{
	
	@Query("{ 'username' : ?0 }")
	public user findByUserName( String mc);
}
