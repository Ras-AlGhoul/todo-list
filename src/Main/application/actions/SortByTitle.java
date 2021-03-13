package Main.application.actions;

import Main.application.app.Menu;
import Main.application.app.Task;
import Main.application.app.ToDoList;
import java.util.Comparator;

/**
 @version
 @since
 @author Yazan Abbas
 **/

public class SortByTitle {

    /**
     this method was implemented to give the user the choice of displaying
     the contents of the todoList by the title of the project **/

    public static void sortByTitle(){
        String displayFormat = "%-20s %-35s %-10s %-10s";

        if (ToDoList.tasks.size()>0) {
            System.out.println(String.format(displayFormat,"PROJECT","TITLE","DUE DATE" , "Done"));
            System.out.println(String.format(displayFormat,"########","#####","#######" , "####"));
        } else {
            System.out.println(Menu.CYAN + "No tasks " + Menu.RESET);
        }

        ToDoList.tasks.stream()
                .sorted(Comparator.comparing(Task::getProject))
                .forEach(task -> System.out.println(String.format(displayFormat,task.getProject(),
                        task.getTitle(),
                        task.getDueDate(),
                        (task.isDone()?"YES":"NO")
                )));
    }
}
