package application.save_read;

import application.app.Menu;
import application.app.ToDoList;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class StoreData {

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
