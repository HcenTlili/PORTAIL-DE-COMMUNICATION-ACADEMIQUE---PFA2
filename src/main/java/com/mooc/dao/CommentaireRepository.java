package com.mooc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.mooc.entities.Commentaire;

@Repository
public interface CommentaireRepository extends MongoRepository<Commentaire, String>{

}
