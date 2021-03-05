package application;
import java.time.LocalDate;


import static application.Task.createTask;

public class Main {

public static void main (String [] args){

    LocalDate date = LocalDate.of(2021, 03, 07);

    System.out.println(createTask(" 1", "Sign contracts", date, "active", "landscape project"));

}

}