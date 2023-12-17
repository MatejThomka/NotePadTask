package com.mth.notepadtask.service;


import com.mth.notepadtask.entity.Task;
import com.mth.notepadtask.exception.TaskException;
import java.util.List;

public interface TaskService {

  void createTask(Task task) throws TaskException;
  Task updateTask(Long id, Task task) throws TaskException;
  void deleteTask(Long id) throws TaskException;
  Task getTask(Long id) throws TaskException;
  List<Task> getAllTask() throws TaskException;
  List<?> getFilteredTask(String filterText) throws TaskException;
}
