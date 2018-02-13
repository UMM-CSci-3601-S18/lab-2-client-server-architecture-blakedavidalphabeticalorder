package umm3601.user;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.user.Database getUser functionality
 */
public class GetTodoByIDFromDB {

  @Test
  public void getFirstTodo() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985a22c04e761776d54");
    assertEquals("Incorrect name", "Blanche", todo.owner);
  }

  @Test
  public void getLastTodo() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985f0a4bbea24084abf");
    assertEquals("Incorrect name", "Barry", todo.owner);
  }
}
