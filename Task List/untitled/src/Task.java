import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Task extends Menu{
    int sessionCheck;


    private List<String> taskList = new ArrayList<>();
    private List<String> completeList = new ArrayList<>();
    private List<String> listHeading = new ArrayList<>(); // headings of lists
    private List<String> listHeadingComplete = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int choice;
    String input;
    Task (int sessionCheck, List<String> taskList, List<String> completeList, List<String> listHeading, List<String> listHeadingComplete){
        this.sessionCheck = sessionCheck;

       if (sessionCheck == 0) {
           // if there was no active session, create a new one, then increment to indicate done
           start(sessionCheck);
           validate();
       } else {

           this.taskList = taskList;
           this.completeList = completeList;
           this.listHeading = listHeading;
           this.listHeadingComplete = listHeadingComplete;
       }

    }


    void validate(){
        sessionCheck = count;
    }


    void menu(){
        System.out.println("Menu");
        System.out.println("1. View Task");
        System.out.println("2. Add Task");
        System.out.println("3. Remove Task");
        System.out.println("4. Completed Task");
        System.out.println("5. Exit");

        choice = scanner.nextInt();

        if (choice == 1){
            viewTask();
        } else if (choice == 2) {
            addTask();
        } else if (choice == 3){
            removeTask();
        } else if (choice == 4) {
            taskFinished();
        } else if (choice == 5){
            System.out.println("All your data will be erased. Have a nice day");
        } else {
            System.out.println("Invalid input");
            System.out.println();
            menu();
        }


    }

    void addTask(){
        System.out.println();
        scanner.nextLine();
        System.out.println("Add Task");
        System.out.println("Enter a task to add");
        System.out.print("Task Heading: ");
        input = scanner.nextLine();
        listHeading.add(input);


        System.out.print("Task Details: ");
        input = scanner.nextLine();
        taskList.add(input);
        System.out.println();
        System.out.println("Task added successfully");

        prompt();
    }

    // prompts user if they still want to add more books
    void prompt(){
        System.out.println("Do you want to add more tasks?");
        choice = scanner.nextInt();

        if (choice == 1){
            addTask();
        } else {
            System.out.println("Taking you to the Main menu");
            System.out.println();
            menu();
        }
    }


    void removeTask(){

        if(taskList.isEmpty()){
            System.out.println("There is no task to remove here");
        } else {
            System.out.println("Remove Task: ");
            System.out.println("Enter task number to remove");
            Iterator<String> taskIterator = taskList.iterator();
            Iterator <String> headingiterator = listHeading.iterator();
            int counter = 1;

            // while there is something ahead of the iterator, keep on looping
            while (taskIterator.hasNext()){
                String task = taskIterator.next();
                String heading = headingiterator.next();
                System.out.println(counter + ": "+ heading);
                System.out.println("    " + task);
                counter++;
            }

            choice = scanner.nextInt();

            // validating the choice to avoid out of bounds error when accessing the list
            if (choice <= counter && choice > 0){
                // if valid, copy the heading from the listHeading to listHeadingComplete, do the same on taskList
                listHeadingComplete.add(listHeading.get(choice-1));
                completeList.add(taskList.get(choice-1));
                listHeading.remove(choice-1);
                taskList.remove(choice-1);
                System.out.println("Marked as complete");
            } else {
                System.out.println("An error occurred.");
            }
        }
        System.out.println();
        menu();
    }

    void taskFinished(){
        if (completeList.isEmpty()){
            System.out.println("You haven't completed any tasks");
            System.out.println();
            menu();
        } else {
            System.out.println("Completed Tasks");
            Iterator<String> complete = completeList.iterator();
            Iterator <String> headingComplete = listHeadingComplete.listIterator();
            int counter = 1;

            while (complete.hasNext()){

                String completedList = complete.next();
                String heading = headingComplete.next();
                System.out.println(counter + ": "+ heading);
                System.out.println("    " + completedList);
                counter++;
            }

            System.out.println("Press 1 to go to the menu");

            choice = scanner.nextInt();
            if (choice == 1){
                menu();
            }
            else {
                System.out.println("Invalid choice");
                System.out.println();
                menu();
            }
        }
    }

    void viewTask(){
        System.out.println("View Tasks");

        if (taskList.isEmpty()){
            System.out.println("You have not added any tasks yet.");
            System.out.println();
            menu();
        } else{
            Iterator <String> taskIterator = taskList.iterator();
            Iterator <String> headingIterator = listHeading.listIterator();
            int counter = 1;

            while (taskIterator.hasNext()){
                String task = taskIterator.next();
                String heading = headingIterator.next();

                System.out.println(counter + ": " + heading);
                System.out.println("    " + task);
                System.out.println();
                counter++;
            }

            System.out.println("Press 1 t return to the menu");
            choice = scanner.nextInt();

            if (choice != 1) {
                System.out.println("Invalid choice");
                menu();
            }



        }
    }


}
