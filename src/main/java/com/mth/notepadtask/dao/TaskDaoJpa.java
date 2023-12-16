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
  public void updateTask(Task task) {
    entityManager.merge(task);
  }

  @Override
  @Transactional
  public void deleteTask(Task task) {
    entityManager.remove(task);
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
