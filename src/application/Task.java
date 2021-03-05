package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {

        private String id;
        private String title;
        private LocalDate date;
        private String status;
        private String project;


        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getStatus() {
            return status;
        }

        public String getProject() {
            return project;
        }

        public void setId(String id) {
            this.id = id;
        }



        public void setTitle(String title) {
            this.title = title;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setProject(String project) {
            this.project = project;
        }


        public static Task createTask(String id, String title, LocalDate dueDate, String status, String projectName) {
            Task task = new Task();

            task.setId(id);
            task.setTitle(title);
            task.setDate(dueDate);
            task.setStatus(status);
            task.setProject(projectName);

            return task;
        }


        @Override
        public String toString() {
            return "ID: " + id + ", " + "Title: " + title + ", " + "Due Date: " +  date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ", " + "Status: "+ status + ", " + "Project: "  + project;
        }

    }

