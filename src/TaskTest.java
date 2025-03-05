import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;



public class TaskTest {
    @Test
    public void testTaskCreation() {
        LocalDateTime dueDate = LocalDateTime.now().plusDays(5);
        Task task = new Task(1, "Test Task", "Description", dueDate);
        
        assertEquals(1, task.getId());
        assertEquals("Test Task", task.getTitle());
        assertEquals("Description", task.getDescription());
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertNull(task.getAssignee());
        assertEquals(dueDate, task.getDueDate());
    }
    
    @Test
    public void testAssignToValidUser() {
        Task task = new Task(1, "Test Task", "Description", LocalDateTime.now().plusDays(5));
        task.assignTo("Alice");
        assertEquals("Alice", task.getAssignee());
    }
    
    @Test
    public void testAssignToInvalidUser() {
        Task task = new Task(1, "Test Task", "Description", LocalDateTime.now().plusDays(5));
        assertThrows(IllegalArgumentException.class, () -> task.assignTo(""));
    }
    
    @Test
    public void testUpdateStatus() {
        Task task = new Task(1, "Test Task", "Description", LocalDateTime.now().plusDays(5));
        task.updateStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }
    
    @Test
    public void testUpdateStatusToNull() {
        Task task = new Task(1, "Test Task", "Description", LocalDateTime.now().plusDays(5));
        assertThrows(IllegalArgumentException.class, () -> task.updateStatus(null));
    }
    
    @Test
    public void testIsOverdue() {
        Task task = new Task(1, "Test Task", "Description", LocalDateTime.now().minusDays(1));
        assertTrue(task.isOverdue());
    }
    
    @Test
    public void testIsNotOverdue() {
        Task task = new Task(1, "Test Task", "Description", LocalDateTime.now().plusDays(1));
        assertFalse(task.isOverdue());
    }
}
