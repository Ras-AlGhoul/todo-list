package Main.application.controllers;

import Main.application.view.Menu;
import Main.application.view.ToDoList;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * This is the StoreData Class and it contains the
 * method responsible for storing data
 * @author Yazan Abbas
 * @since 1.0
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
            Menu.message(e.getMessage(),true);
            return false;
        }
    }
}
