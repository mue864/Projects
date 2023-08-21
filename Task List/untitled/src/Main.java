import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<String> taskList = new ArrayList<>();
        List<String> completList = new ArrayList<>();
        List<String> listHeading = new ArrayList<>();
        List<String> headingComplete = new ArrayList<>();
        int session = 0;

        Task task = new Task(session, taskList, completList, listHeading, headingComplete);

        task.menu();

    }
}