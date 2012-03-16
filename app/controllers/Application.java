package controllers;

import models.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Main application.
 * @author davidlin
 */
public class Application extends Controller {

  static Form<Task> taskForm = form(Task.class);

  /**
   * Index page.
   * @return HTML result
   */
  public static Result index() {
    return redirect(routes.Application.tasks());
  }

  /**
   * Tasks page.
   * @return HTML result
   */
  public static Result tasks() {
    return ok(views.html.index.render(Task.all(), taskForm));
  }

  /**
   * Create new task.
   * @return HTML result
   */
  public static Result newTask() {
    Form<Task> filledForm = taskForm.bindFromRequest();
    if (filledForm.hasErrors()) {
      return badRequest(views.html.index.render(Task.all(), filledForm));
    }
    else {
      Task.create(filledForm.get());
      return redirect(routes.Application.tasks());
    }
  }

  /**
   * Delete task.
   * @param id The task's id
   * @return HTML result
   */
  public static Result deleteTask(Long id) {
    Task.delete(id);
    return redirect(routes.Application.tasks());
  }

}