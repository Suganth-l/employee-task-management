package com.example.employeetask.service;

import com.example.employeetask.model.Employee;
import com.example.employeetask.repository.EmployeeRepository;
import com.example.employeetask.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final EmployeeRepository employees;
    private final TaskRepository tasks;
    public ReportService(EmployeeRepository employees, TaskRepository tasks) { this.employees = employees; this.tasks = tasks; }

    public List<Map<String, Object>> taskCountReport() {
        Map<Long, Long> counts = tasks.findAll().stream().filter(t -> t.getEmployeeId() != null)
                .collect(Collectors.groupingBy(t -> t.getEmployeeId(), Collectors.counting()));
        return employees.findAll().stream().sorted(Comparator.comparing(Employee::getId)).map(e -> {
            Map<String, Object> row = new java.util.LinkedHashMap<>();
            row.put("employeeId", e.getId()); row.put("employeeName", e.getName());
            row.put("taskCount", counts.getOrDefault(e.getId(), 0L));
            return row;
        }).collect(Collectors.toList());
    }
}
