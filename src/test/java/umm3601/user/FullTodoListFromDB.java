package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FullTodoListFromDB {
  @Test
  public void totalTodoCount() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    assertEquals("Incorrect total number of todos", 300, allTodos.length);
  }

  @Test
  public void firstTodoInFullList() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo firstTodo = allTodos[0];
    assertEquals("Incorrect id", "58895985a22c04e761776d54", firstTodo._id);
    assertEquals("Incorrect owner", "Blanche", firstTodo.owner);
    assertEquals("Incorrect status", false, firstTodo.status);
    assertEquals("Incorrect body", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", firstTodo.body);
    assertEquals("Incorrect category", "software design", firstTodo.category);
  }
}
