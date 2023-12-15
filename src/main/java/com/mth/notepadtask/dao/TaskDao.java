package com.mth.notepadtask.dao;

import com.mth.notepadtask.entity.Task;
import com.mth.notepadtask.exception.TaskException;
import java.util.List;

public interface TaskDao {

  void createTask(Task task) throws TaskException;
  Task updateTask(Long id, Task task);
  void deleteTask(Long id);
  Task getTask(Long id);
  List<Task> getAllTask();
}
