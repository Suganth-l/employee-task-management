package com.example.employeetask.controller;

import com.example.employeetask.dto.EmployeeRequest;
import com.example.employeetask.model.Employee;
import com.example.employeetask.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@Valid @RequestBody EmployeeRequest request) { return service.create(request); }
    @GetMapping
    public List<Employee> findAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) { return service.findById(id); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
    @GetMapping("/sort/salary")
    public List<Employee> sortBySalary() { return service.sortBySalary(); }
    @GetMapping("/highest-salary")
    public Employee highestPaid() { return service.highestPaid(); }
}
