package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByOwnerFromDB {
  @Test
  public void filterTodosByOwner() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] ownerFry = db.filterTodosByOwner(allTodos, "Fry");
    assertEquals("Incorrect number of entries with owner Fry", 61, ownerFry.length);

    Todo[] ownerBlanche = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Incorrect number of entries with owner Blanche", 43, ownerBlanche.length);
  }
    @Test
    public void listTodosWithOwnerFilter() throws IOException {
      Database db = new Database("src/main/data/todos.json");
      Map<String, String[]> queryParams = new HashMap<>();

      queryParams.put("owner", new String[] {"Fry"});
      Todo[] ownerFry = db.listTodos(queryParams);
      assertEquals("Incorrect number of entries with owner Fry", 61, ownerFry.length);

      queryParams.put("owner", new String[] {"Blanche"});
      Todo[] ownerBlanche = db.listTodos(queryParams);
      assertEquals("Incorrect number of entries with owner Blanche", 43, ownerBlanche.length);
  }
}
