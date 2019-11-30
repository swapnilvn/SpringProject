
package com.swapnil.HibernateCriteria.integration.repository;

import com.swapnil.HibernateCriteria.integration.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository
    extends JpaRepository<Employee, Long>
{


}
