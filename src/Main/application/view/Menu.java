package Main.application.view;

/**
 * This is the Menu Class and it contains various
 * display Menu options and messages
 *
 * @author Yazan Abbas
 * @since
 **/

public class Menu {

    //Created final field to hold code to RESET the text font color
    public static final String RESET = "\u001B[0m";
    //Created final field to hold code to change the text font color to CYAN
    public static final String CYAN = "\u001B[36m";
    //Created final field to hold code to change the text font color to Yellow
    public static final String YELLOW = "\u001B[33m";

    /**
     * Created this method to display the main menu on
     * terminal to display all options for user.
     *
     * @param incompletedTaskCount takes the number of incompleted tasks to display in main menu
     * @param doneTaskCount        takes the number of done tasks to display in main menu
     **/

    public static void menu(int incompletedTaskCount, int doneTaskCount) {
        System.out.println("\nMAIN MENU");
        System.out.println("########\n");
        System.out.println("You have " + Menu.CYAN
                + incompletedTaskCount + " task(s) todo "
                + Menu.RESET + "and " + Menu.YELLOW
                + doneTaskCount + " Done task(s)\n" + Menu.RESET);
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Manage Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit\n");
        System.out.print("Please enter your choice [1-4]: ");
    }

    /**
     * Created this method to display a menu to terminal to give the
     * user the choice to display all tasks on the todoList by date or by project
     **/

    public static void tasksMenu() {
        System.out.println("\nDisplay All Tasks");
        System.out.println("###################\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List by date" +
                Menu.CYAN + " [default choice, just hit ENTER ]" + Menu.RESET);
        System.out.println("(2) Show Task List by project title");
        System.out.print("\nPlease enter your choice [1-2]: ");
    }

    /**
     * Created this method to let the user choose a task from the todoList to edit
     **/

    public static void selectTaskNumber() {
        System.out.println(YELLOW);
        System.out.print("===>  Select a task number and hit ENTER : ");
        System.out.print(RESET);
    }

    /**
     * Created this method to display the Edit tasks menu options
     * on terminal for the user to choose from
     **/

    public static void editTaskMenu() {
        System.out.println("\nTask Edit Options");
        System.out.println("###################\n");
        System.out.println("Pick an option: ");
        System.out.println("(1) Modify selected task");
        System.out.println("(2) Mark selected task as Done");
        System.out.println("(3) Delete selected task");
        System.out.println("(4) Return to main menu "
                + Menu.CYAN + " [default choice, just hit ENTER]" + Menu.RESET);
        System.out.print("\nPlease enter your choice [1-4]: ");
    }

    /**
     * Created this method to display the goodbye
     * message "Hej då! !" during the ending of the program
     **/

    public static void endingMemo() {
        System.out.println(YELLOW);
        System.out.println("===>  Saved to data file");
        System.out.println("===>  Hej då!!");
        System.out.println(RESET);
    }

    /**
     * This method was created to display the error message if a user input an
     * option which is not from the choices given in main menu
     **/

    public static void errorMemo() {
        System.out.println(CYAN);
        System.out.println("===> Incorrect choice: Please enter a correct number ");
        System.out.print(RESET);
    }

    /**
     * Created this method to display any message in CYAN or YELLOW text on terminal
     *
     * @param message a text message as String
     * @param warning a boolean value, if true print warning with Yellow text, and if false
     *                print message in CYAN text on terminal
     **/

    public static void message(String message, boolean warning) {
        System.out.println(warning ? YELLOW : CYAN);
        System.out.println("===> " + message);
        System.out.println(RESET);
    }


}
