package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;

public class ToDoListTest extends TestCase {
   // Define Test Fixtures
   private ToDoList toDoList;

   public ToDoListTest() {
      super();
   }

   @Before
   public void setUp() throws Exception {
      // Initialise Test Fixtures
      toDoList = new ToDoList();
   }

   @After
   public void tearDown() throws Exception {
      // Uninitialise test Fixtures
   }

   @Test
   public void testAddTask() {
      Task t1 = new Task("myTask");
      toDoList.addTask(t1);

      assertEquals(t1, toDoList.getTask("myTask"));
   }

   @Test
   public void testGetStatus() {
      Task t1 = new Task("myTask", true);

      toDoList.addTask(t1);

      boolean isComplete = toDoList.getStatus("myTask");

      assertEquals(isComplete, t1.isComplete());
   }

   @Test
   public void testRemoveTask() {
      Task t1 = new Task("myTask");

      toDoList.addTask(t1);

      assertEquals(t1, toDoList.removeTask("myTask"));
   }

   @Test
   public void testGetCompletedTasks() {
      toDoList.addTask(new Task("myTask", true));
      toDoList.addTask(new Task("myTask2", true));

      Collection<Task> tasks = toDoList.getCompletedTasks();

      ToDoList toDoList2 = new ToDoList();
      toDoList.addTask(new Task("myTask", false));
      toDoList.addTask(new Task("myTask2", false));

      Collection<Task> tasks2 = toDoList2.getCompletedTasks();

      assertFalse(tasks.isEmpty());
      assertTrue(tasks2.isEmpty());
   }
}
