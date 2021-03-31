package com.pragmanila.listAPI.employee;



import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//DATA ACCESS LAYER

@Repository //responsible in DATA ACCESS
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    //checking for duplicate email
    @Query("SELECT s FROM Employee  s WHERE s.email = ?1")
    Optional<Employee> findEmployeeByEmail(String email);
}
