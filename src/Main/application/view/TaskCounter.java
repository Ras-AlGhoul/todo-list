package Main.application.view;

import Main.application.controllers.Task;

import java.util.ArrayList;

public class TaskCounter {

    public static int doneCount(ArrayList<Task> tasks) {
        return (int) tasks.stream()
                .filter(Task::isDone)
                .count();
    }

    public static int inCompletedCount(ArrayList<Task> tasks) {
        return (int) tasks.stream()
                .filter(task -> !task.isDone())
                .count();
    }
}
