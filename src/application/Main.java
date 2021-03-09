package application;

import application.app.ToDoList;

public class Main {

    public static void main(String args[]) {
        ToDoList todoList = new ToDoList();
        todoList.runToDoList(todoList, "data.obj");

    }

}