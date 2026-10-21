package com.example.employeetask.model;

public class Task {
    private Long taskId;
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private Long employeeId;

    public Task() {}
    public Task(Long taskId, String title, String description, TaskStatus status, Priority priority, Long employeeId) {
        this.taskId = taskId; this.title = title; this.description = description;
        this.status = status; this.priority = priority; this.employeeId = employeeId;
    }
    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
}
