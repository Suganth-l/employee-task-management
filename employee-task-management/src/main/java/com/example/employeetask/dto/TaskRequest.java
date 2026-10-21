package com.example.employeetask.dto;

import com.example.employeetask.model.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TaskRequest {
    @NotNull(message = "Task ID is required")
    @Positive(message = "Task ID must be greater than zero")
    private Long taskId;
    @NotBlank(message = "Title must not be empty")
    private String title;
    private String description;
    @NotNull(message = "Priority is required")
    private Priority priority;
    private Long employeeId;

    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
}
