package com.mth.notepadtask.api;

import com.mth.notepadtask.entity.Task;
import com.mth.notepadtask.exception.TaskException;
import com.mth.notepadtask.service.TaskService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/task")
public class TaskAPI {

  @EJB
  private TaskService taskService;

  @POST
  @Path("/create")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createTask(Task task) {

    try {
      taskService.createTask(task);
    } catch (TaskException e) {
      return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }

    return Response.status(Response.Status.CREATED).entity("Task created!").build();
  }

  @PUT
  @Path("/update/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateTask(@PathParam("id") Long id,
                             Task task) {
    Task updatedTask;

    try {
      updatedTask = taskService.updateTask(id, task);
    } catch (TaskException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }

    return Response.status(Response.Status.OK).entity(updatedTask).build();
  }

  @DELETE
  @Path("/delete/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteTask(@PathParam("id") Long id) {

    try {
      taskService.deleteTask(id);
    } catch (TaskException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }

    return Response.status(Response.Status.OK).entity("Task " + id + " deleted successfully!").build();
  }

  @GET
  @Path("/get/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTask(@PathParam("id") Long id) {

    Task task;

    try {
      task = taskService.getTask(id);
    } catch (TaskException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }

    return Response.status(Response.Status.OK).entity(task).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllTask() {

    List<Task> taskList;

    try {
      taskList = taskService.getAllTask();
    } catch (TaskException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }

    return Response.status(Response.Status.OK).entity(taskList).build();
  }
}
