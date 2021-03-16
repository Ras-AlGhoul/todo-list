package Main.application;

import Main.application.view.ToDoList;

/**
 * This is the main Class and it contains the
 * main method
 * @author Yazan Abbas
 * @since 1.0
 **/

public class Main {

    public static void main(String args[]) {

        // creating a new object of TodoList to hold all tasks and their data
        ToDoList todoList = new ToDoList();

        //calling the function on the todoList we created so we can run the application
        todoList.runToDoList(todoList, "data.obj");

    }

}