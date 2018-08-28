package com.mooc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mooc.entities.Cours;

@Repository
//RestResource(collectionResourceRel="cours" , path="cours")
public interface CoursRepository extends MongoRepository<Cours, String> {

}



