package com.mth.notepadtask.dao;

import com.mth.notepadtask.entity.Task;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TaskDaoJpa implements TaskDao {

  @PersistenceContext
  private EntityManager entityManager;
  @Override
  public Task createTask(Task task) {
    entityManager.persist(task);
    return task;
  }

  @Override
  public Task updateTask(Long id, Task task) {
    Task updateTask = entityManager.find(Task.class, id);
    updateTask.setTitle(task.getTitle());
    updateTask.setContent(task.getContent());
    return entityManager.merge(updateTask);
  }

  @Override
  public void deleteTask(Long id) {
    Task task = entityManager.find(Task.class, id);
    if (task != null) {
      entityManager.remove(task);
    }
  }

  @Override
  public Task getTask(Long id) {
    return entityManager.find(Task.class, id);
  }

  @Override
  public List<Task> getAllTask() {
    return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
  }
}
