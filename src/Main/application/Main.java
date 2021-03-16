package Main.application;

import Main.application.view.ToDoList;

/**
 * This is the Menu Class and it contains various
 * display Menu options and messages
 * @author Yazan Abbas
 * @since
 **/

public class Main {

    public static void main(String args[]) {

        // creating a new object of TodoList to hold all tasks and their data
        ToDoList todoList = new ToDoList();

        //calling the function on the todoList we created so we can run the application
        todoList.runToDoList(todoList, "data.obj");

    }

}