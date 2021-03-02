package application;
import java.time.LocalDate;
import java.util.Date;

import static application.Task.createTask;

public class Main {

public static void main (String [] args){

    LocalDate date = LocalDate.of(2020, 12, 12);

    System.out.println(createTask("1", "Coffee", date, "active", "coffe project"));

}

}