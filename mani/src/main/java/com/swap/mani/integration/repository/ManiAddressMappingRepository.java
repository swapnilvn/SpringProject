package com.swap.mani.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swap.mani.integration.domain.ManiAddressMapping;

@Repository
public interface ManiAddressMappingRepository extends JpaRepository<ManiAddressMapping, Long>{

	List<ManiAddressMapping> findByManiId(Long id);

}
