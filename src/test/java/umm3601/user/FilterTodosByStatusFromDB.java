package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByStatusFromDB {
  @Test
  public void filterTodosByStatus() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] statusTrue = db.filteredTodosByStatus(allTodos, true);
    assertEquals("Incorrect number of entries with status true", 143, statusTrue.length);

    Todo[] statusFalse = db.filteredTodosByStatus(allTodos, false);
    assertEquals("Incorrect number of entries with status false", 157, statusFalse.length);
  }

  @Test
  public void listTodosWithStatusFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[] {"complete"});
    Todo[] statusTrue = db.listTodos(queryParams);
    assertEquals("Incorrect number of entries with status true", 143, statusTrue.length);

    queryParams.put("status", new String[] {"incomplete"});
    Todo[] statusFalse = db.listTodos(queryParams);
    assertEquals("Incorrect number of entries with status false", 157, statusFalse.length);
  }

}
