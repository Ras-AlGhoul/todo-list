package Tests;

import Main.application.controllers.Task;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task;


    @Test
    public void testSettingEmptyTitle() {
        boolean successful = false;

        try {
            task.setTitle("");
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            successful = true;
        }

        assertEquals(true, successful);
    }

    @Test
    void getTitle() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        assertEquals("Hello World", task1.getTitle());
    }

    @Test
    void setTitle() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        task1.setTitle("Hello World Updated");
        assertEquals("Hello World Updated", task1.getTitle());
    }

    @Test
    void getProject() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        assertEquals("Coffee", task1.getProject());
    }

    @Test
    void setProject() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        task1.setProject("Tea");
        assertEquals("Tea", task1.getProject());
    }

    @Test
    void isDone() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        task1.markDone();
        assertEquals(true, task1.isDone());

    }

    @Test
    void markDone() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        assertEquals(true, task1.markDone());
    }

    @Test
    void getDueDate() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        assertEquals(LocalDate.of(2021, 12, 8), task1.getDueDate());
    }

    @Test
    void setDueDate() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        LocalDate newLocalDate = LocalDate.parse("2021-12-12");
        task1.setDueDate(newLocalDate);
        assertEquals(LocalDate.of(2021, 12, 12), task1.getDueDate());
    }

    @Test
    void formattedStringOfTask() {
        Task task1 = new Task("Hello World", "Coffee", LocalDate.of(2021, 12, 8));
        task1.markDone();
        assertEquals("\nTitle     : Hello World\n" +
                "Project   : Coffee\n" +
                "Status    : DONE\n" +
                "Due Date  : 2021-12-08" +
                "\n", task1.formattedStringOfTask());
    }


}