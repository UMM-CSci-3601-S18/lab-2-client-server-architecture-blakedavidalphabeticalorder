package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByContainsFromDB {
  @Test
  public void filterTodosByContains() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] contains_ipsum = db.filteredTodosByBody(allTodos, "ipsum");
    assertEquals("Incorrect number of entries with owner Fry", 60, contains_ipsum.length);

    Todo[] contains_nisi = db.filteredTodosByBody(allTodos, "nisi");
    assertEquals("Incorrect number of entries with owner Blanche", 77, contains_nisi.length);
  }
  @Test
  public void listTodosWithContainsFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("contains", new String[] {"ipsum"});
    Todo[] contains_ipsum = db.listTodos(queryParams);
    assertEquals("Incorrect number of entries with owner Fry", 60, contains_ipsum.length);

    queryParams.put("contains", new String[] {"nisi"});
    Todo[] contains_nisi = db.listTodos(queryParams);
    assertEquals("Incorrect number of entries with owner Blanche", 77, contains_nisi.length);
  }
}
