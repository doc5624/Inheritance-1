import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    String[] subTask = {"проснутся", "поспать", "поесть"};
    Epic epic = new Epic(12, subTask);
    SimpleTask simpleTask = new SimpleTask(25, "простая задача");
    Meeting meeting = new Meeting(45,"тема 1", "проект 1", "2024-08-01 13:00:00");

    @Test
    public void testEpic(){

        Boolean expected = true;
        Boolean actual = epic.matches("поспать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noTestEpic(){

        Boolean expected = false;
        Boolean actual = epic.matches(" не поесть");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTask(){

        Boolean expected = true;
        Boolean actual = simpleTask.matches("простая задача");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notTestSimpleTask(){

        Boolean expected = false;
        Boolean actual = simpleTask.matches("другая задача");

        Assertions.assertEquals(expected, actual);
    }

}
