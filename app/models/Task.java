package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Task object.
 * @author davidlin
 */
@Entity
public class Task extends Model {

  private static final long serialVersionUID = 1L;

  @Id
  public Long id;

  @Required
  public String label;
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static Finder<Long,Task> find = new Finder(Long.class, Task.class);

  /**
   * Get all tasks in database.
   * @return List of all tasks
   */
  public static List<Task> all() {
    return find.all();
  }

  /**
   * Create a new task.
   * @param task The task
   */
  public static void create(Task task) {
    task.save();
  }

  /**
   * Delete a task.
   * @param id The id of the task to delete
   */
  public static void delete(Long id) {
    find.ref(id).delete();
  }

}
