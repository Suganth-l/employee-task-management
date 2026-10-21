package com.example.employeetask.repository;

import com.example.employeetask.model.Task;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class TaskRepository {
    private final ConcurrentMap<Long, Task> tasks = new ConcurrentHashMap<>();
    public boolean existsById(Long id) { return tasks.containsKey(id); }
    public Task save(Task task) { tasks.put(task.getTaskId(), task); return task; }
    public Task findById(Long id) { return tasks.get(id); }
    public List<Task> findAll() { return new ArrayList<>(tasks.values()); }
}
