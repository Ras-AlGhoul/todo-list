package Tests;

import Main.application.controllers.Task;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task;



    @Test
    public void testSettingEmptyTitle() {
        boolean successful=false;

        try {
            task.setTitle("");
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            successful = true;
        }

        assertEquals(true,successful);
    }




}