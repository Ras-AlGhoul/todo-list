package application.controllers;

import application.Menu;
import application.Task;
import application.ToDoList;
import java.util.Comparator;

public class Display {
    public static void displayTasks(String sortBy) {
        Menu.separator('=',75);
        System.out.println(
                "Total Tasks = " + ToDoList.tasks.size() +
                        "\t\t (Completed = " + ToDoList.completedCount() + "\t\t" +
                        Menu.RED_TEXT + " Not Compeleted = " + ToDoList.notCompletedCount() + Menu.RESET_TEXT +
                        " )");
        Menu.separator('=',75);

        if (sortBy.equals("2")) {
            String displayFormat = "%-20s %-35s %-10s %-10s";

            if (ToDoList.tasks.size()>0) {
                System.out.println(String.format(displayFormat,"PROJECT","TITLE","DUE DATE","COMPLETED"));
                System.out.println(String.format(displayFormat,"=======","=====","========","========="));
            } else {
                System.out.println(Menu.RED_TEXT + "No tasks to show" + Menu.RESET_TEXT);
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


    public static void indexTasks() {
        String displayFormat = "%-4s%-35s %-20s %-10s %-10s";

        if (ToDoList.tasks.size()>0) {
            System.out.println(String.format(displayFormat,"NUM","TITLE","PROJECT","DUE DATE","COMPLETED"));
            System.out.println(String.format(displayFormat,"===","=====","=======","========","========="));
        } else {
            System.out.println(Menu.RED_TEXT + "No tasks to show" + Menu.RESET_TEXT);
        }

        ToDoList.tasks.stream()
                .forEach(task -> System.out.println(String.format(displayFormat,
                        ToDoList.tasks.indexOf(task)+1,
                        task.getTitle(),
                        task.getProject(),
                        task.getDueDate(),
                        (task.isDone()?"YES":"NO")
                )));
    }

}
