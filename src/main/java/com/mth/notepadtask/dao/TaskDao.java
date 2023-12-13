package com.mth.notepadtask.dao;

import com.mth.notepadtask.entity.Task;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface TaskDao {

  Task createTask(Task task);
  Task updateTask(Long id, Task task);
  void deleteTask(Long id);
  Task getTask(Long id);
  List<Task> getAllTask();
}
