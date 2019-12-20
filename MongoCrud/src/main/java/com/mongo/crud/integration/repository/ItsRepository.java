package com.mongo.crud.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.crud.integration.domain.ItsEntity;

//public interface ItsRepository extends JpaRepository<ItsEntity, Long>{

public interface ItsRepository extends MongoRepository<ItsEntity, Long>{

	
}
