package Main.application.actions;

import Main.application.app.Menu;
import Main.application.app.Task;
import Main.application.app.ToDoList;

import java.util.Scanner;

public class ManageTask {


    public static void actOnTask(String selectedTask) throws NullPointerException {
        try {

            if (selectedTask.trim().equals("") || selectedTask == null) {
                throw new NullPointerException("EMPTY/NULL TASK Index: Returning to Main Menu");
            }


            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > ToDoList.tasks.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK Index NOT GIVEN FROM TASK LIST: Returning to Main Menu");
            }

            Task task = ToDoList.tasks.get(taskIndex);

            Menu.message("Task Index " + selectedTask + "  is selected:" + task.formattedStringOfTask(), false);

            Menu.editTaskMenu();
            Scanner scan = new Scanner(System.in);
            String editChoice = scan.nextLine();
            switch (editChoice) {
                case "1":
                    EditTask.updateTask(task);
                    break;
                case "2":
                    task.markDone();
                    Menu.message("Task Index " + selectedTask + " is marked as Done: Returning to Main Menu", false);
                    break;
                case "3":
                    ToDoList.tasks.remove(task);
                    Menu.message("Task Index " + selectedTask + " is Deleted: Returning to Main Menu", true);
                    break;
                default:
                    Menu.message("Returning to Main Menu", true);
            }
        } catch (Exception e) {
            Menu.message(e.getMessage(), true);
        }
    }
}
