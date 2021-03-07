package application.app;

public class Menu {
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";

    public static void menu(int incompletedTaskCount, int DoneTaskCount) {
        System.out.println("\nMAIN MENU");
        System.out.println("########\n");
        System.out.println("You have " + Menu.CYAN
                + incompletedTaskCount + " task(s) todo "
                + Menu.RESET + "and " + Menu.YELLOW
                + DoneTaskCount + " Done task(s)\n" + Menu.RESET);
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Manage Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit\n");
        System.out.print("Please enter your choice [1-4]: ");
    }

    public static void tasksMenu() {
        System.out.println("\nDisplay All Tasks");
        System.out.println("###################\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List by date" +
                Menu.CYAN + " [default choice, just hit ENTER ]" + Menu.RESET);
        System.out.println("(2) Show Task List by project");
        System.out.print("\nPlease enter your choice [1-2]: ");
    }


    public static void selectTaskNumber() {
        System.out.println(YELLOW);
        System.out.print("===>  Select a task number and hit ENTER : ");
        System.out.print(RESET);
    }

    public static void editTaskMenu() {
        System.out.println("\nTask Edit Options");
        System.out.println("###################\n");
        System.out.println("Pick an option: ");
        System.out.println("(1) Modify selected task");
        System.out.println("(2) Mark selected task as Done");
        System.out.println("(3) Delete selected task");
        System.out.println("(4) Return to main menu "
                + Menu.CYAN + " [default choice, just hit ENTER]"+ Menu.RESET);
        System.out.print("\nPlease enter your choice [1-4]: ");
    }

    public static void endingMemo() {
        System.out.println(YELLOW);
        System.out.println("===>  Saved to data file");
        System.out.println("===>  Hej då!!");
        System.out.println(RESET);
    }

    public static void errorMemo() {
        System.out.println(CYAN);
        System.out.println("===> Incorrect choice: Please enter a correct number ");
        System.out.print(RESET);
    }

    public static void Message(String message, boolean warning) {
        System.out.println(warning? CYAN : YELLOW);
        System.out.println("===> " + message);
        System.out.println(RESET);
    }



}
