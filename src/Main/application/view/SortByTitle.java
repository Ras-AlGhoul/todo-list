package Main.application.view;

import Main.application.controllers.Task;
import java.util.Comparator;

/**
        * This is the Menu Class and it contains various
        * display Menu options and messages
        *
        * @author Yazan Abbas
        * @since
 **/
public class SortByTitle {
    /**
     this method was implemented to give the user the choice of displaying
     the contents of the todoList by the title of the project **/

    public static void sortByTitle() {
        String displayFormat = "%-20s %-35s %-10s %-10s";

        if (ToDoList.tasks.size() > 0) {
            System.out.println(String.format(displayFormat, "PROJECT", "TITLE", "DUE DATE", "Done"));
            System.out.println(String.format(displayFormat, "########", "#####", "#######", "####"));
        } else {
            System.out.println(Menu.CYAN + "No tasks " + Menu.RESET);
        }

        ToDoList.tasks.stream()
                .sorted(Comparator.comparing(Task::getProject))
                .forEach(task -> System.out.println(String.format(displayFormat, task.getProject(),
                        task.getTitle(),
                        task.getDueDate(),
                        (task.isDone() ? "YES" : "NO")
                )));
    }
}
