package Main.application.controllers;

import Main.application.view.Menu;
import Main.application.view.ToDoList;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This is the Menu Class and it contains various
 * display Menu options and messages
 *
 * @author Yazan Abbas
 * @since
 **/

public class ReadData {

    /**
     * This method is created to read the data file which will hold the data of saved tasks
     * @param filename is a string defining the full path of data file
     * @return true if the reading functioning was successful, otherwise false
     */

    public static boolean readFromFile(String filename) {
        boolean status = false;

        try {
            if (!Files.isReadable(Paths.get(filename))) {
                Menu.message("The data file, i.e., " + filename + " does not exists", true);
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ToDoList.tasks = (ArrayList<Task>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            Menu.message(e.getMessage(),true);
            return false;
        }
    }
}
