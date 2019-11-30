package com.swapnil.Swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapnil.Swagger.domain.Mosambi;

public interface MosambiRepository extends JpaRepository<Mosambi, String>{

	List<Mosambi> findByPrice(String color);

}
