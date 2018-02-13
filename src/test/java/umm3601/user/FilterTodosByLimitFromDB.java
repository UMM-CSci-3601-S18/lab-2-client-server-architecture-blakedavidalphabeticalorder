package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByLimitFromDB {
  @Test
  public void filterTodosByLimit() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] limitSix = db.limitTodos(allTodos, 6);
    assertEquals("Incorrect number of entries for limit 6", 6, limitSix.length);

    Todo[] limitTen = db.limitTodos(allTodos, 10);
    assertEquals("Incorrect number of entries for limit 10", 10, limitTen.length);
  }
}
