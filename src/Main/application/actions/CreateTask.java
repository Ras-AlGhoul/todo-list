package Main.application.actions;

import Main.application.app.Menu;
import Main.application.app.Task;
import Main.application.app.ToDoList;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateTask {

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
