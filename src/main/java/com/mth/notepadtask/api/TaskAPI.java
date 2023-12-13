package com.mth.notepadtask.api;

import com.mth.notepadtask.entity.Task;
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
    Task createdTask = taskService.createTask(task);
    return Response.status(Response.Status.CREATED).entity(createdTask).build();
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateTask(@PathParam("id") Long id, Task task) {
    Task updatedTask = taskService.updateTask(id, task);
    return Response.status(Response.Status.ACCEPTED).entity(updatedTask).build();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteTask(@PathParam("id") Long id) {
    taskService.deleteTask(id);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTask(@PathParam("id") Long id) {
    Task task = taskService.getTask(id);
    return Response.status(Response.Status.FOUND).entity(task).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllTask() {
    List<Task> taskList = taskService.getAllTask();
    return Response.status(Response.Status.FOUND).entity(taskList).build();
  }
}
