package com.mooc.dao;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mooc.entities.Fichier;
import com.mooc.entities.Quiz;
import com.mooc.entities.Slides;

@Repository
public interface SlidesRepository extends MongoRepository<Slides, String> {
	
	

}
