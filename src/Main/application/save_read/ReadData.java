package Main.application.save_read;

import Main.application.app.Menu;
import Main.application.app.Task;
import Main.application.app.ToDoList;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadData {


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
