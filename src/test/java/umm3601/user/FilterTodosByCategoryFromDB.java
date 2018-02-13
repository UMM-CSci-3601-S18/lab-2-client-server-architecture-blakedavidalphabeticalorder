package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategoryFromDB {
  @Test
  public void filterTodosByCategory() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] categoryVideo_Games = db.filteredTodosByCategory(allTodos, "video games");
    assertEquals("Incorrect number of entries with category video games", 71, categoryVideo_Games.length);

    Todo[] categorySoftware_Design = db.filteredTodosByCategory(allTodos, "software design");
    assertEquals("Incorrect number of entries with category software design", 74, categorySoftware_Design.length);
  }
  @Test
  public void listTodosWithCategoryFilter() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[] {"video games"});
    Todo[] categoryVideo_Games = db.listTodos(queryParams);
    assertEquals("Incorrect number of entries with category video games", 71, categoryVideo_Games.length);

    queryParams.put("category", new String[] {"software design"});
    Todo[] categorySoftware_Design = db.listTodos(queryParams);
    assertEquals("Incorrect number of entries with category software design", 74, categorySoftware_Design.length);
  }
}
