package com.example.employeetask.controller;

import com.example.employeetask.dto.TaskRequest;
import com.example.employeetask.dto.TaskStatusRequest;
import com.example.employeetask.model.Task;
import com.example.employeetask.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) { this.service = service; }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@Valid @RequestBody TaskRequest request) { return service.create(request); }
    @PutMapping("/tasks/{taskId}/assign/{employeeId}")
    public Task assign(@PathVariable Long taskId, @PathVariable Long employeeId) { return service.assign(taskId, employeeId); }
    @PutMapping("/tasks/{taskId}/status")
    public Task updateStatus(@PathVariable Long taskId, @Valid @RequestBody TaskStatusRequest request) {
        return service.updateStatus(taskId, request.getStatus());
    }
    @GetMapping("/employees/{id}/tasks")
    public List<Task> byEmployee(@PathVariable("id") Long employeeId) { return service.byEmployee(employeeId); }
    @GetMapping("/tasks/sort/priority")
    public List<Task> sortByPriority() { return service.sortByPriority(); }
    @GetMapping("/tasks/completed")
    public List<Task> completed() { return service.completed(); }
    @GetMapping("/tasks")
    public List<Task> findAll() { return service.findAll(); }
}
