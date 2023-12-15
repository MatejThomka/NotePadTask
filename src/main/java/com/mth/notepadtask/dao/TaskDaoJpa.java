package com.mth.notepadtask.dao;

import com.mth.notepadtask.entity.Task;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
public class TaskDaoJpa implements TaskDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public void createTask(Task task) {
    entityManager.persist(task);
  }

  @Override
  @Transactional
  public Task updateTask(Long id, Task task) {
    Task updateTask = entityManager.find(Task.class, id);
    updateTask.setTitle(task.getTitle());
    updateTask.setContent(task.getContent());
    return entityManager.merge(updateTask);
  }

  @Override
  @Transactional
  public void deleteTask(Long id) {
    Task task = entityManager.find(Task.class, id);
    if (task != null) {
      entityManager.remove(task);
    }
  }

  @Override
  @Transactional
  public Task getTask(Long id) {
    return entityManager.find(Task.class, id);
  }

  @Override
  @Transactional
  public List<Task> getAllTask() {
    return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
  }
}
