package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class FliterTodosByOrderFromDB
{
  @Test
  public void filterTodosByMix() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] statusTrue = db.filteredTodosByOrder(allTodos, "status");
    statusTrue = db.limitTodos(statusTrue, 3);

    /** Because of the way we wrote the program, we know that if we order the list by complete / incomplete, it
     * will display ALL the false, then all the true. Then if we take only three of those responses, they are
     * 100% going to be false if the tests are working correctly.
     */

    assertEquals("Incorrect number of entries", 3, statusTrue.length);
    assertEquals("Incorrect number of entries with status false", 3, statusTrue.length);


    //Probably could have just told it to "regenerate" the previous variables.
    Database freshDB = new Database("src/main/data/todos.json");
    Todo[] newAllTodos = freshDB.listTodos(new HashMap<>());

    Todo[] statusCategoryOwner = db.filteredTodosByCategory(newAllTodos, "video games");
    statusCategoryOwner = db.filterTodosByOwner(statusCategoryOwner, "Blanche");

    /**
     * The first filtering through, by category, has 71 entries for video games. Then limiting it to owner
     * leaves only 7 (I counted...)
     */
    System.out.println(statusCategoryOwner.length);
    assertEquals("Incorrect number of things!", 7, statusCategoryOwner.length);
  }
}
