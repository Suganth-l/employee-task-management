package com.example.employeetask.service;

import com.example.employeetask.dto.EmployeeRequest;
import com.example.employeetask.exception.DuplicateResourceException;
import com.example.employeetask.exception.ResourceNotFoundException;
import com.example.employeetask.model.Employee;
import com.example.employeetask.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) { this.repository = repository; }

    public Employee create(EmployeeRequest request) {
        if (repository.existsById(request.getId())) throw new DuplicateResourceException("Employee ID already exists: " + request.getId());
        Employee employee = new Employee(request.getId(), request.getName().trim(), request.getEmail().trim(),
                request.getDepartment().trim(), request.getSalary());
        return repository.save(employee);
    }
    public List<Employee> findAll() { return repository.findAll(); }
    public Employee findById(Long id) {
        Employee employee = repository.findById(id);
        if (employee == null) throw new ResourceNotFoundException("Employee not found: " + id);
        return employee;
    }
    public void delete(Long id) {
        if (!repository.deleteById(id)) throw new ResourceNotFoundException("Employee not found: " + id);
    }
    public List<Employee> sortBySalary() {
        return repository.findAll().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
    }
    public Employee highestPaid() {
        return repository.findAll().stream().max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new ResourceNotFoundException("No employees found"));
    }
}
