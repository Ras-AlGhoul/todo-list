package Main.application.actions;

import Main.application.app.Menu;
import Main.application.app.Task;
import Main.application.app.ToDoList;

import java.util.Comparator;

public class SortByDate {

     public static void sortByDate(){

            String displayFormat = "%-10s %-35s %-20s %-10s";

            if (ToDoList.tasks.size() > 0) {
                System.out.println(String.format(displayFormat,"DUE DATE","TITLE","PROJECT" , "Done"));
                System.out.println(String.format(displayFormat,"########","#####","#######" , "####"));
            } else {
                System.out.println(Menu.CYAN + "No tasks" + Menu.RESET);
            }

            ToDoList.tasks.stream()
                    .sorted(Comparator.comparing(Task::getDueDate))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getDueDate(),
                            task.getTitle(),
                            task.getProject(),
                            (task.isDone() ? "YES" : "NO")
                    )));
        }

}
