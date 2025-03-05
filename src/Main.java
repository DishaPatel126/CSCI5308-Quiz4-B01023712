import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Creating a Task
        System.out.println("Enter Task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Task Title: ");
        String title = scanner.nextLine();

        System.out.println("Enter Task Description: ");
        String description = scanner.nextLine();

        System.out.println("Enter Due Date (yyyy-MM-dd HH:mm): ");
        String dueDateString = scanner.nextLine();
        LocalDateTime dueDate = LocalDateTime.parse(dueDateString, formatter);

        Task task = new Task(id, title, description, dueDate);
        System.out.println("Task Created: " + task.getTitle());

        // Assigning Task
        System.out.println("Enter Assignee Name: ");
        String assignee = scanner.nextLine();
        task.assignTo(assignee);
        System.out.println("Task assigned to: " + task.getAssignee());

        // Updating Task Status
        System.out.println("Choose Status: (1) TODO (2) IN_PROGRESS (3) DONE");
        int statusChoice = scanner.nextInt();

        TaskStatus newStatus = switch (statusChoice) {
            case 1 -> TaskStatus.TODO;
            case 2 -> TaskStatus.IN_PROGRESS;
            case 3 -> TaskStatus.DONE;
            default -> throw new IllegalArgumentException("Invalid status choice");
        };

        task.updateStatus(newStatus);
        System.out.println("Task status updated to: " + task.getStatus());

        // Checking if Task is Overdue
        if (task.isOverdue()) {
            System.out.println("Warning: Task is overdue!");
        } else {
            System.out.println("Task is within the deadline.");
        }

        scanner.close();
    }
}
