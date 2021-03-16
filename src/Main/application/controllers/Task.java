package Main.application.controllers;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This is the Task Class and it contains various
 * methods responsible for tasks
 * @author Yazan Abbas
 * @since 1.0
 **/

public class Task implements Serializable {
    //Created String field which holds the title of a task
    private String title;
    //Created String which holds the name of project linked with task
    private String project;
    //Created LocalDate field which holds the task due date as yyyy-mm-dd format
    private LocalDate dueDate;
    //created boolean field which holds the done status of a task, if true: the task is done, otherwise false
    private boolean done;

    /**
     * This constructor is made to Create an object of Task class
     * @param title   is a String that holds the title of a task.
     * @param project is String that holds the name of project linked with a certain task.
     * @param dueDate The due date of a certain task and it's formatted as yyyy-mm-dd
     */

    public Task(String title, String project, LocalDate dueDate) {

        this.setTitle(title);

        this.setProject(project);

        this.done = false;
        this.setDueDate(dueDate);
    }



    /**
     * This method is created to get the task title
     * @return the title of a task string
     */

    public String getTitle() {
        return this.title;
    }

    /**
     * This method is created to set the title of a Task object
     * @param title is a String that holds the title of a task
     * @throws NullPointerException if title string is null or empty
     */

    public void setTitle(String title) throws NullPointerException {
        if (title.trim().equals("") || title == null) {
            throw new NullPointerException("REQUIRED: Title can not be empty.");
        }
        this.title = title.trim();
    }

    /**
     * A method to get the project name
     * @return the project name string
     */

    public String getProject() {
        return this.project;
    }

    /**
     * This method is used to set the project name
     * @param project is a String that holds the name of project linked with task
     */

    public void setProject(String project) {
        this.project = project.trim();
    }

    /**
     * This method is used to get the Done status of a certain task
     * @return True if the task is marked as Done, else it will return false
     */

    public boolean isDone() {
        return this.done;
    }

    /**
     * This method is used to mark a task as Done task
     * @return an updated value of the field Done
     */

    public boolean markDone() {
        this.done = true;
        return this.done;
    }

    /**
     * This method is created to get the due date of task
     * @return the due date of the task
     */

    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * This method is used to set the due date of task
     * @param dueDate The due date of the task as yyyy-mm-dd format
     * @throws DateTimeException if given date is an expired date
     */

    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        if (dueDate.compareTo(LocalDate.now()) < 0) {
            throw new DateTimeException("Past Date not allowed");
        }

        //To make sure date is saved as yyyy-MM-dd Format
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    /**
     * This method is used to get the task details as formatted string to display in several lines
     * @return formatted string of all the specific fields of the task
     */

    public String formattedStringOfTask() {
        return (
                "\nTitle     : " + title +
                        "\nProject   : " + project +
                        "\nStatus    : " + (done ? "DONE" : "INCOMPLETED") +
                        "\nDue Date  : " + dueDate +
                        "\n");
    }



}

