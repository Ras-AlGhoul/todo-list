package Main.application.save_read;

import Main.application.app.Menu;
import Main.application.app.ToDoList;

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
            Menu.message(e.getMessage(),true);
            return false;
        }
    }
}
