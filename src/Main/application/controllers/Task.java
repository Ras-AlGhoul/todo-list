package Main.application.controllers;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {
    private String title;
    private String project;
    private LocalDate dueDate;
    private boolean done;

    public Task(String title, String project, LocalDate dueDate) {

        this.setTitle(title);
        this.setProject(project);
        this.done = false;
        this.setDueDate(dueDate);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) throws NullPointerException {
        if (title.trim().equals("") || title == null) {
            throw new NullPointerException("REQUIRED: Title can not be empty.");
        }
        this.title = title.trim();
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project.trim();
    }

    public boolean isDone() {
        return this.done;
    }


    public boolean markDone() {
        this.done = true;
        return this.done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        if (dueDate.compareTo(LocalDate.now()) < 0) {
            throw new DateTimeException("Past Date not allowed");
        }

        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    public String formattedStringOfTask() {
        return (
                "\nTitle     : " + title +
                        "\nProject   : " + project +
                        "\nStatus    : " + (done ? "DONE" : "INCOMPLETED") +
                        "\nDue Date  : " + dueDate +
                        "\n");
    }


}

