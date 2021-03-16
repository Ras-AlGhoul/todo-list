package Main.application.controllers;

import Main.application.view.Menu;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * This is the EditTask Class and it contains the
 * method responsible for updating a certain task
 * @author Yazan Abbas
 * @since 1.0
 **/

public class EditTask {

    /**
     * this method is designed to read the value from user
     * and update a given Task in the todoList of Tasks
     * @param task the task parameter value need to be updated with user input
     * @return true, if the Tasks object is updated in todoList, otherwise false
     **/

    public static boolean updateTask(Task task) {
        Scanner scan = new Scanner(System.in);
        boolean isTaskUpdated = false;

        try {
            System.out.println(Menu.YELLOW + "Please enter the following to update task:"
                    + "\nIf you do not want to change any field, just hit ENTER!" + Menu.RESET);
            System.out.print("===> Task Title  : ");
            String title = scan.nextLine();
            if (!(title.trim().equals("") || title == null)) {
                task.setTitle(title);
                isTaskUpdated = true;
            }

            System.out.print("===> Project Name: ");
            String project = scan.nextLine();
            if (!(project.trim().equals("") || project == null)) {
                task.setProject(project);
                isTaskUpdated = true;
            }

            System.out.print("===> Due Date [example: 2021-03-30] : ");
            String dueDate = scan.nextLine();
            if (!(dueDate.trim().equals("") || dueDate == null)) {
                task.setDueDate(LocalDate.parse(dueDate));
                isTaskUpdated = true;
            }

            Menu.message("Task is " + (isTaskUpdated ? "updated successfully" : "NOT modified") + ": Returning to Main Menu", false);

            return true;
        } catch (Exception e) {
            Menu.message(e.getMessage(), true);
            return false;
        }
    }
}
