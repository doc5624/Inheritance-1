import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        SimpleTask simpleTask = new SimpleTask(1, "Посетить магазин");

        String[] subtasks = {"Бумага", "Ручка", "Карандаш", "Покупки"};
        Epic epic = new Epic(5, subtasks);

        Meeting meeting = new Meeting(
                7,
                "Покупки",
                "Ашан",
                "2024-08-02 14:30"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Покупки");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notTestSearch() {
        SimpleTask simpleTask = new SimpleTask(1, "Посетить магазин");

        String[] subtasks = {"Бумага", "Ручка", "Карандаш", "Покупки"};
        Epic epic = new Epic(5, subtasks);

        Meeting meeting = new Meeting(
                7,
                "Покупки",
                "Ашан",
                "2024-08-02 14:30"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Продажи");
        Assertions.assertArrayEquals(expected, actual);
    }
}
