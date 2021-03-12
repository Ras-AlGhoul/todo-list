package Main.application.app;

import Main.application.actions.CreateTask;
import Main.application.actions.Display;
import Main.application.actions.ManageTask;

import Main.application.save_read.ReadData;
import Main.application.save_read.StoreData;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public static int doneCount() {
        return (int) tasks.stream()
                .filter(Task::isDone)
                .count();
    }


    public static int inCompletedCount() {
        return (int) tasks.stream()
                .filter(task -> !task.isDone())
                .count();
    }

    public void runToDoList(ToDoList toDoList, String filename) {
        String userSelection = "0";

        try {
            Scanner input = new Scanner(System.in);

            ReadData.readFromFile(filename);

            Menu.message("Welcome Back!", true);

            while (!userSelection.equals("4")) {
                Menu.menu(toDoList.inCompletedCount(), toDoList.doneCount());
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



