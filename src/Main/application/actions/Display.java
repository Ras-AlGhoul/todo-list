package Main.application.actions;

import Main.application.app.Menu;
import Main.application.app.ToDoList;

/**
 * This is the Menu Class and it contains various
 * display Menu options and messages
 *
 * @author Yazan Abbas
 * @since
 **/

public class Display {

    /** this method is created to display the contents of todoList
       @param sortBy a string holding a number, "2" for sorting by project,
       otherwise it will sort by by date **/

    public static void displayTasks(String sortBy) {

        System.out.println("########################################################################");
        System.out.println(
                "Total Tasks = " + ToDoList.tasks.size() +
                        "\t\t (Done = " + ToDoList.DoneCount() + "\t\t" +
                        Menu.CYAN + " Incompleted = " + ToDoList.InCompletedCount() + Menu.RESET +
                        " )");

        System.out.println("########################################################################");
        if (sortBy.equals("2")) {
            SortByTitle.sortByTitle();
        } else {
            SortByDate.sortByDate();
        }
    }

    /*this method was designed to display the contents of todoList with first column as task number*/

    public static void indexTasks() {
        String displayFormat = "%-4s%-35s %-20s %-10s %-10s";

        if (ToDoList.tasks.size() > 0) {
            System.out.println(String.format(displayFormat, "Index", "TITLE", "PROJECT", "DUE DATE", "Done"));
            System.out.println(String.format(displayFormat, "#####", "#####", "#######", "#########", "####"));
        } else {
            System.out.println(Menu.CYAN + "No tasks to show" + Menu.RESET);
        }
        ToDoList.tasks.stream()
                .forEach(task -> System.out.println(String.format(displayFormat,
                        ToDoList.tasks.indexOf(task) + 1,
                        task.getTitle(),
                        task.getProject(),
                        task.getDueDate(),
                        (task.isDone() ? "YES" : "NO")
                )));
    }
}
