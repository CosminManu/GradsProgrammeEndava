package com.endava.gradsapp.repo;

import com.endava.gradsapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeesById(Long id);
    Employee findEmployeesById(Long id);
}
