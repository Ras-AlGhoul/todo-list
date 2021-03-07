package application.controllers;

import application.Menu;
import application.Task;
import application.ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageTask {


    public static void actOnTask(String selectedTask) throws NullPointerException {
        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("") || selectedTask == null) {
                throw new NullPointerException("EMPTY/NULL TASK NUM: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > ToDoList.tasks.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK NUM NOT GIVEN FROM TASK LIST: Returning to Main Menu");
            }

            Task task = ToDoList.tasks.get(taskIndex);

            Menu.showMessage("Task Num " + selectedTask + "  is selected:" + task.formattedStringOfTask(), false);

            Menu.editTaskMenu();
            Scanner scan = new Scanner(System.in);
            String editChoice = scan.nextLine();
            switch (editChoice) {
                case "1":
                    EditTask.updateTask(task);
                    break;
                case "2":
                    task.markDone();
                    Menu.showMessage("Task Num " + selectedTask + " is marked as Completed: Returning to Main Menu", false);
                    break;
                case "3":
                    ToDoList.tasks.remove(task);
                    Menu.showMessage("Task Num " + selectedTask + " is Deleted: Returning to Main Menu", true);
                    break;
                default:
                    Menu.showMessage("Returning to Main Menu", true);
            }
        } catch (Exception e) {
            Menu.showMessage(e.getMessage(),true);
        }
    }
}
