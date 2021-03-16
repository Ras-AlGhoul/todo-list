package Main.application.view;

import Main.application.controllers.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Menu Class and it contains various
 * display Menu options and messages
 * @author Yazan Abbas
 * @since
 **/

public class ToDoList {
    //Created field of an array list of task objects
    public static ArrayList<Task> tasks;

    /**
     * Created a constructor to instantiate an object from our class
     */
    public ToDoList() {
        tasks = new ArrayList<>();
    }

    /**
     * Created this method to run the "To Do List" application with a switch statement
     * @param toDoList to take the todoList and run actions on it
     * @param filename to save tasks on
     */

    public void runToDoList(ToDoList toDoList, String filename) {
        //string to hold the selection that the user will enter
        String userSelection = "0";

        try {
            Scanner input = new Scanner(System.in);

            // reading the date from task data file
            ReadData.readFromFile(filename);

            Menu.message("Welcome Back!", true);

            while (!userSelection.equals("4")) {
                Menu.menu(TaskCounter.inCompletedCount(tasks), TaskCounter.doneCount(tasks));
                userSelection = input.nextLine();

                switch (userSelection) {
                    case "1":
                        Menu.tasksMenu();
                        Display.displayTasks(input.nextLine());
                        break;
                    case "2":
                        CreateTask.createTask();
                        break;
                    case "3":
                        Display.indexTasks();
                        Menu.selectTaskNumber();
                        ManageTask.actOnTask(input.nextLine());
                        break;
                    case "4":
                        break;

                    default:
                        Menu.errorMemo();
                }
            }

            // saving the task details in data file
            StoreData.saveToFile(filename);
            Menu.endingMemo();

        } catch (Exception e) {
            Menu.message("UNCAUGHT EXCEPTION THROWN", true);
            System.out.println("Trying to write the unsaved data of all tasks in data file");
            StoreData.saveToFile(filename);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

}



