package com.swap.mani.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swap.mani.integration.domain.Mani;
@Repository
public interface ManiRepository extends JpaRepository<Mani, Long>{

	@Modifying
	@Query("DELETE FROM Mani mn WHERE mn.id=?1")
	void deleteById(Long id);

}
