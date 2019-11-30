package com.swapnil.curd.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapnil.curd.integration.domain.Swapnil;

@Repository
public interface SwapnilRepository extends JpaRepository<Swapnil, Long>{

}
