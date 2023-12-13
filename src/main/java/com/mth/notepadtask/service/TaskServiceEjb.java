package com.mth.notepadtask.service;

import com.mth.notepadtask.dao.TaskDao;
import com.mth.notepadtask.entity.Task;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class TaskServiceEjb implements TaskService {


  @EJB
  private TaskDao taskDao;

  @Override
  public Task createTask(Task task) {
    return taskDao.createTask(task);
  }

  @Override
  public Task updateTask(Long id, Task task) {
    return taskDao.updateTask(id, task);
  }

  @Override
  public void deleteTask(Long id) {
    taskDao.deleteTask(id);
  }

  @Override
  public Task getTask(Long id) {
    return taskDao.getTask(id);
  }

  @Override
  public List<Task> getAllTask() {
    return taskDao.getAllTask();
  }
}
