package Main.application.save_read;

import Main.application.app.Menu;
import Main.application.app.ToDoList;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * This is the Menu Class and it contains various
 * display Menu options and messages
 *
 * @author Yazan Abbas
 * @since
 **/

public class StoreData {

    /**
     * This method is created to write the data of Tasks from todoList to data file.
     * @param filename is a string defining the full path of the data file
     * @return true if the reading functioning of the file was successful, otherwise false
     */

    public static boolean saveToFile(String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(ToDoList.tasks);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            Menu.Message(e.getMessage(),true);
            return false;
        }
    }
}
