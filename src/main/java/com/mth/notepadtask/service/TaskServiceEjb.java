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

  /**
   * Creates a new task based on the provided Task object.
   * *
   * This method ensures that both the title and content of the task are provided,
   * throwing a TaskException with an appropriate error message if either is missing.
   * After validation, the task creation is delegated to the taskDao object.
   *
   * @param task - The Task object representing the task to be created.
   * @throws TaskException - If the title or content of the task is missing.
   */
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

  /**
   * Updates an existing task identified by its unique ID with the provided Task object.
   * *
   * This method first checks if a task with the specified ID exists. If not, it throws
   * a TaskException with an appropriate error message. If the task is found, it updates
   * the task's title and content based on the non-null values in the provided Task object.
   * Finally, the updated task is persisted using the taskDao object.
   * @param id - The unique identifier of the task to be updated.
   * @param task - The Task object containing updated information.
   * @return The Task object representing the updated task.
   * @throws TaskException - If the specified task ID is not found.
   */
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

  /**
   * Deletes an existing task identified by its unique ID.
   * *
   * This method checks if a task with the specified ID exists. If not, it throws
   * a TaskException with an appropriate error message. If the task is found, it is
   * assigned to a local variable for reference, and the taskDao object is used to
   * delete the task from the underlying data store.
   *
   * @param id - The unique identifier of the task to be deleted.
   * @throws TaskException - If the specified task ID is not found.
   */
  @Override
  public void deleteTask(Long id) throws TaskException {

    Task task;

    if (taskDao.getTask(id) == null) {
      throw new TaskException("Task under this ID is missing!");
    } else {
      task = taskDao.getTask(id);
    }

    taskDao.deleteTask(task);
  }

  /**
   * Retrieves the details of a task identified by its unique ID.
   * *
   * This method checks if a task with the specified ID exists. If not, it throws
   * a TaskException with an appropriate error message. If the task is found, it is
   * returned as a Task object, providing the details of the identified task.
   *
   * @param id - The unique identifier of the task to be retrieved.
   * @return The Task object representing the details of the identified task.
   * @throws TaskException - If the specified task ID is not found.
   */
  @Override
  public Task getTask(Long id) throws TaskException {

    if (taskDao.getTask(id) == null) {
      throw new TaskException("Task under this ID is missing!");
    }

    return taskDao.getTask(id);
  }

  /**
   * Retrieves a list of all tasks.
   * *
   * This method invokes the taskDao to retrieve a list of all tasks. If the retrieved
   * list is empty, indicating no tasks are present, a TaskException is thrown with an
   * appropriate error message. Otherwise, the method returns the list of tasks.
   *
   * @return A list containing all tasks.
   * @throws TaskException - If there are no tasks available.
   */
  @Override
  public List<Task> getAllTask() throws TaskException {

    List<Task> taskList = taskDao.getAllTask();

    if (taskList.isEmpty()) {
      throw new TaskException("There is nothing inside!");
    }

    return taskList;
  }

  /**
   * Retrieves a filtered list of tasks based on the provided filter text.
   * *
   * This method delegates the task filtering to the underlying TaskDao,
   *  which uses a JPQL query to search for tasks with titles or content
   *  containing the specified filter text. If the retrieved list is empty,
   *  indicating no tasks match the filter, a TaskException is thrown with
   *  an appropriate error message.
   *
   * @param filterText - The filter text used to search for tasks.
   * @return A list containing tasks that match the filter text.
   * @throws TaskException - If there are no tasks matching the filter text.
   */
  @Override
  public List<?> getFilteredTask(String filterText) throws TaskException {

    List<?> taskList = taskDao.filterTask(filterText);

    if (taskList.isEmpty()) {
      throw new TaskException("There is nothing inside with this text!");
    }

    return taskList;
  }
}
