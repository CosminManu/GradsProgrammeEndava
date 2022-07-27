package com.endava.gradsapp.service;

import com.endava.gradsapp.exceptions.EmployeeNotFoundException;
import com.endava.gradsapp.model.Employee;
import com.endava.gradsapp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional()
public class EmployeeService {
    private final EmployeeRepo employeeRepo;        //used to do CRUD op

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){         //POST
        employee.setCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){              //GET
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long Id){
        return employeeRepo.findEmployeesById(Id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + Id + " was not found"));
    }

    public Employee updateEmployee(Employee employee){      //PUT
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
