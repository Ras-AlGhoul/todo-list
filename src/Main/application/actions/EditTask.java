package Main.application.actions;

import Main.application.app.Menu;
import Main.application.app.Task;

import java.time.LocalDate;
import java.util.Scanner;

public class EditTask {
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

            Menu.Message("Task is " + (isTaskUpdated ? "updated successfully" : "NOT modified") + ": Returning to Main Menu", false);

            return true;
        } catch (Exception e) {
            Menu.Message(e.getMessage(), true);
            return false;
        }
    }
}
