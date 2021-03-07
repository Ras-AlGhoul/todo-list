package application.controllers;

import application.Menu;
import application.Task;

import java.time.LocalDate;
import java.util.Scanner;

public class EditTask {
    public static boolean updateTask(Task task) {
        Scanner scan = new Scanner(System.in);
        boolean isTaskUpdated = false;

        try {
            System.out.println(Menu.GREEN_TEXT + "Please enter the following details to update a task:"
                    + "\nIf you do not want to change any field, just press ENTER key!" + Menu.RESET_TEXT);
            System.out.print(">>> Task Title  : ");
            String title = scan.nextLine();
            if (!(title.trim().equals("") || title == null)) {
                task.setTitle(title);
                isTaskUpdated = true;
            }

            System.out.print(">>> Project Name: ");
            String project = scan.nextLine();
            if (!(project.trim().equals("") || project == null)) {
                task.setProject(project);
                isTaskUpdated = true;
            }

            System.out.print(">>> Due Date [example: 2019-12-31] : ");
            String dueDate = scan.nextLine();
            if (!(dueDate.trim().equals("") || dueDate == null)) {
                task.setDueDate(LocalDate.parse(dueDate));
                isTaskUpdated = true;
            }

            Menu.showMessage("Task is " + (isTaskUpdated ? "updated successfully" : "NOT modified") + ": Returning to Main Menu", false);

            return true;
        } catch (Exception e) {
            Menu.showMessage(e.getMessage(), true);
            return false;
        }
    }
}
