package Main.application.actions;

import Main.application.app.Menu;
import Main.application.app.Task;
import Main.application.app.ToDoList;

import java.util.Scanner;

public class ManageTask {

    /** this method was created to select a specific Task from todoList and perform edits on
        @param selectedTask Task number that is selected by user from given list to perform edits on
        @throws NullPointerException if task number of given as empty string or null
        @throws ArrayIndexOutOfBoundsException if task number does not fall in index range of todoList **/


    public static void actOnTask(String selectedTask) throws NullPointerException {
        try {
            // if statement to check if the task number is an empty string or null
            if (selectedTask.trim().equals("") || selectedTask == null) {
                throw new NullPointerException("EMPTY/NULL TASK Index: Returning to Main Menu");
            }


            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > ToDoList.tasks.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK Index NOT GIVEN FROM TASK LIST: Returning to Main Menu");
            }

            Task task = ToDoList.tasks.get(taskIndex);

            Menu.Message("Task Index " + selectedTask + "  is selected:" + task.formattedStringOfTask(), false);

            Menu.editTaskMenu();
            Scanner scan = new Scanner(System.in);
            String editChoice = scan.nextLine();
            switch (editChoice) {
                case "1":
                    EditTask.updateTask(task);
                    break;
                case "2":
                    task.markDone();
                    Menu.Message("Task Index " + selectedTask + " is marked as Done: Returning to Main Menu", false);
                    break;
                case "3":
                    ToDoList.tasks.remove(task);
                    Menu.Message("Task Index " + selectedTask + " is Deleted: Returning to Main Menu", true);
                    break;
                default:
                    Menu.Message("Returning to Main Menu", true);
            }
        } catch (Exception e) {
            Menu.Message(e.getMessage(), true);
        }
    }
}
