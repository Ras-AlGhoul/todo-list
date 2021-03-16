package Main.application.view;

import Main.application.controllers.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Menu Class and it contains various
 * display Menu options and messages
 *
 * @author Yazan Abbas
 * @since
 **/

public class ToDoList {
    //Created field
    public static ArrayList<Task> tasks;



    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void runToDoList(ToDoList toDoList, String filename) {
        String userSelection = "0";

        try {
            Scanner input = new Scanner(System.in);

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



