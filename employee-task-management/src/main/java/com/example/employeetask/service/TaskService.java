package com.example.employeetask.service;

import com.example.employeetask.dto.TaskRequest;
import com.example.employeetask.exception.DuplicateResourceException;
import com.example.employeetask.exception.ResourceNotFoundException;
import com.example.employeetask.model.Priority;
import com.example.employeetask.model.Task;
import com.example.employeetask.model.TaskStatus;
import com.example.employeetask.repository.EmployeeRepository;
import com.example.employeetask.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository; this.employeeRepository = employeeRepository;
    }
    public Task create(TaskRequest request) {
        if (taskRepository.existsById(request.getTaskId())) throw new DuplicateResourceException("Task ID already exists: " + request.getTaskId());
        if (request.getEmployeeId() != null && !employeeRepository.existsById(request.getEmployeeId()))
            throw new ResourceNotFoundException("Employee not found: " + request.getEmployeeId());
        Task task = new Task(request.getTaskId(), request.getTitle().trim(), request.getDescription(),
                TaskStatus.PENDING, request.getPriority(), request.getEmployeeId());
        return taskRepository.save(task);
    }
    public Task assign(Long taskId, Long employeeId) {
        Task task = getTask(taskId);
        if (!employeeRepository.existsById(employeeId)) throw new ResourceNotFoundException("Employee not found: " + employeeId);
        task.setEmployeeId(employeeId);
        return taskRepository.save(task);
    }
    public Task updateStatus(Long taskId, TaskStatus status) {
        Task task = getTask(taskId); task.setStatus(status); return taskRepository.save(task);
    }
    public List<Task> byEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) throw new ResourceNotFoundException("Employee not found: " + employeeId);
        return taskRepository.findAll().stream().filter(t -> employeeId.equals(t.getEmployeeId())).toList();
    }
    public List<Task> findAll() { return taskRepository.findAll(); }
    public List<Task> sortByPriority() {
        Map<Priority, Integer> rank = Map.of(Priority.HIGH, 1, Priority.MEDIUM, 2, Priority.LOW, 3);
        return taskRepository.findAll().stream().sorted(Comparator.comparingInt(t -> rank.get(t.getPriority()))).toList();
    }
    public List<Task> completed() {
        return taskRepository.findAll().stream().filter(t -> t.getStatus() == TaskStatus.COMPLETED).toList();
    }
    public Map<Long, Long> taskCountByEmployee() {
        return taskRepository.findAll().stream().filter(t -> t.getEmployeeId() != null)
                .collect(Collectors.groupingBy(Task::getEmployeeId, Collectors.counting()));
    }
    private Task getTask(Long id) {
        Task task = taskRepository.findById(id);
        if (task == null) throw new ResourceNotFoundException("Task not found: " + id);
        return task;
    }
}
