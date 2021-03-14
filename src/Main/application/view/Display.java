package Main.application.view;


public class Display {
    public static void displayTasks(String sortBy) {

        System.out.println("########################################################################");
        System.out.println(
                "Total Tasks = " + ToDoList.tasks.size() +
                        "\t\t (Done = " + TaskCounter.doneCount(ToDoList.tasks) + "\t\t" +
                        Menu.CYAN + " Incompleted = " + TaskCounter.inCompletedCount(ToDoList.tasks) + Menu.RESET +
                        " )");

        System.out.println("########################################################################");
        if (sortBy.equals("2")) {
            SortByTitle.sortByTitle();
        } else {
            SortByDate.sortByDate();
        }
    }

    public static void indexTasks() {
        String displayFormat = "%-4s%-35s %-20s %-10s %-10s";

        if (ToDoList.tasks.size() > 0) {
            System.out.println(String.format(displayFormat, "Index", "TITLE", "PROJECT", "DUE DATE", "Done"));
            System.out.println(String.format(displayFormat, "#####", "#####", "#######", "#########", "####"));
        } else {
            System.out.println(Menu.CYAN + "No tasks to show" + Menu.RESET);
        }
        ToDoList.tasks.stream()
                .forEach(task -> System.out.println(String.format(displayFormat,
                        ToDoList.tasks.indexOf(task) + 1,
                        task.getTitle(),
                        task.getProject(),
                        task.getDueDate(),
                        (task.isDone() ? "YES" : "NO")
                )));
    }
}
