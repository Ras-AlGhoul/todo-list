package Main.application.controllers;

import Main.application.view.Menu;
import Main.application.view.ToDoList;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * This is the CreateTask class and it contains the
 * method responsible for creating a task
 * @author Yazan Abbas
 * @since 1.0
 **/

public class CreateTask {


    /**
     * this method was deigned to read the value from user to
     * create a Task object and to add in the List of Tasks
     * it will @return true, if the Tasks object is created and
     * added, otherwise false
     **/

    public static boolean createTask() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println(Menu.YELLOW + "Please enter the following details: " + Menu.RESET);
            System.out.print("===> Task Title  : ");
            String title = scan.nextLine();
            System.out.print("===> Project Name: ");
            String project = scan.nextLine();
            System.out.print("===> Due Date [example: 2021-03-30] : ");
            LocalDate dueDate = LocalDate.parse(scan.nextLine());

            ToDoList.tasks.add(new Task(title, project, dueDate));
            Menu.message("Task successfully added ", false);

            return true;
        } catch (Exception e) {
            Menu.message(e.getMessage(), true);
            return false;
        }

    }
}
