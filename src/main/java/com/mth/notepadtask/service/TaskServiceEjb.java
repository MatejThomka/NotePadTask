package com.mth.notepadtask.service;

import com.mth.notepadtask.dao.TaskDao;
import com.mth.notepadtask.entity.Task;
import com.mth.notepadtask.exception.TaskException;
import jakarta.ejb.Stateless;
import java.util.List;
import jakarta.inject.*;


@Stateless
public class TaskServiceEjb implements TaskService {

  @Inject
  private TaskDao taskDao;

  @Override
  public void createTask(Task task) throws TaskException {

    if (task.getTitle() == null) {
      throw new TaskException("Title is missing!");
    }

    if (task.getContent() == null) {
      throw new TaskException("Content is missing!");
    }

    taskDao.createTask(task);
  }

  @Override
  public Task updateTask(Long id, Task task) throws TaskException {

    if (taskDao.getTask(id) == null) {
      throw new TaskException("Task under this ID is missing!");
    }

    Task updatedTask = taskDao.getTask(id);

    if (task.getTitle() != null) {
      updatedTask.setTitle(task.getTitle());
    }

    if (task.getContent() != null) {
      updatedTask.setContent(task.getContent());
    }

    taskDao.updateTask(updatedTask);

    return updatedTask;
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
