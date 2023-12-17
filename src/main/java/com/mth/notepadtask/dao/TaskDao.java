package com.mth.notepadtask.dao;

import com.mth.notepadtask.entity.Task;
import java.util.List;

public interface TaskDao {

  void createTask(Task task);
  void updateTask(Task task);
  void deleteTask(Task task);
  Task getTask(Long id);
  List<Task> getAllTask();
  List<?> filterTask(String filterQuery);
}
