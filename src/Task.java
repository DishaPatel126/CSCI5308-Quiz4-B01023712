import java.time.LocalDateTime;
enum TaskStatus {
    TODO, IN_PROGRESS, DONE, OVERDUE;
}

public class Task {

    private int id;
        private String title;
        private String description;
        private TaskStatus status;
        private String assignee;
        private LocalDateTime dueDate;
        
        public Task(int id, String title, String description, LocalDateTime dueDate) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.status = TaskStatus.TODO;
            this.dueDate = dueDate;
            this.assignee = null;
        }
        
        public void assignTo(String teamMember) {

            this.assignee = teamMember;
        }
        
        public void updateStatus(TaskStatus newStatus) {

            this.status = newStatus;
        }
        
        public boolean isOverdue() {
            return true;
        }
        
        // Getters for testing purposes
        public int getId() { return id; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public TaskStatus getStatus() { return status; }
        public String getAssignee() { return assignee; }
        public LocalDateTime getDueDate() { return dueDate; }
}