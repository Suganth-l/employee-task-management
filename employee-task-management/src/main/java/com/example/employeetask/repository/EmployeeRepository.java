package com.example.employeetask.repository;

import com.example.employeetask.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class EmployeeRepository {
    private final ConcurrentMap<Long, Employee> employees = new ConcurrentHashMap<>();
    public boolean existsById(Long id) { return employees.containsKey(id); }
    public Employee save(Employee employee) { employees.put(employee.getId(), employee); return employee; }
    public Employee findById(Long id) { return employees.get(id); }
    public List<Employee> findAll() { return new ArrayList<>(employees.values()); }
    public boolean deleteById(Long id) { return employees.remove(id) != null; }
}
