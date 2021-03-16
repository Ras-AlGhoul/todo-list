package Main.application.view;

import Main.application.controllers.Task;

import java.util.ArrayList;

/**
 * This is the TaskCounter class and it contains various
 * methods responsible for counting tasks
 * @author Yazan Abbas
 * @since 1.0
 **/

public class TaskCounter {

    /**
     * created this method to count the number of done tasks with Done status
     * @param tasks is list of the tasks
     * @return number of tasks with Done status
     */

    public static int doneCount(ArrayList<Task> tasks) {
        return (int) tasks.stream()
                .filter(Task::isDone)
                .count();
    }

    /**
     * created this method to count the number of uncompleted tasks with incompleted status
     * @param tasks is list of the tasks
     * @return number of tasks with incompleted status
     */

    public static int inCompletedCount(ArrayList<Task> tasks) {
        return (int) tasks.stream()
                .filter(task -> !task.isDone())
                .count();
    }
}
