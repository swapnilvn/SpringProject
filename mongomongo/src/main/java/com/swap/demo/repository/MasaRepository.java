package com.swap.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swap.demo.domain.Masa;

@Repository
public interface MasaRepository extends MongoRepository<Masa, Long> {

	Optional<Masa> findByIdAndActive(Long id, Boolean active);


}
