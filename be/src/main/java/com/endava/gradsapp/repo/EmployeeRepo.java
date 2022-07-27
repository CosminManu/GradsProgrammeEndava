package com.endava.gradsapp.repo;

import com.endava.gradsapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Modifying
    @Query("DELETE from Employee WHERE id = :id")
    void deleteEmployeeById(Long id);

    @Query("SELECT a from Employee a WHERE  a.id = :id")
    Optional<Employee> findEmployeesById(Long id);
}
