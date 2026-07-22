package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование StudentList")
class StudentListTest {

    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("Добавление студента в список")
    void shouldAddStudentToList() {
        Student student = new Student("Иван", "Москва");

        studentList.addStudent(student);
        List<Student> students = studentList.getStudentsFromSpecificCity("Москва");

        assertThat(students)
                .hasSize(1)
                .containsExactly(student);
    }

    @Test
    @DisplayName("Попытка добавить null — не должно быть исключения")
    void shouldNotThrowException_whenAddingNullStudent() {
        // Проверяем, что метод не выбрасывает исключение
        studentList.addStudent(null);

        List<Student> students = studentList.getStudentsFromSpecificCity("Москва");
        assertThat(students)
                .isEmpty();
    }

    @Test
    @DisplayName("Фильтрация студентов по городу")
    void shouldFilterStudentsByCity() {
        Student ivan = new Student("Иван", "Москва");
        Student maria = new Student("Мария", "Москва");
        Student petr = new Student("Пётр", "Казань");

        studentList.addStudent(ivan);
        studentList.addStudent(maria);
        studentList.addStudent(petr);

        List<Student> moscowStudents = studentList.getStudentsFromSpecificCity("Москва");

        assertThat(moscowStudents)
                .hasSize(2)
                .containsExactlyInAnyOrder(ivan, maria)
                .allMatch(s -> s.city().equals("Москва"));
    }

    @Test
    @DisplayName("Фильтрация по городу, которого нет в списке")
    void shouldReturnEmptyList_whenNoStudentsFromCity() {
        Student ivan = new Student("Иван", "Москва");
        Student maria = new Student("Мария", "Санкт-Петербург");

        studentList.addStudent(ivan);
        studentList.addStudent(maria);

        List<Student> novgorodStudents = studentList
                .getStudentsFromSpecificCity("Великий Новгород");

        assertThat(novgorodStudents)
                .isEmpty();
    }

    @Test
    @DisplayName("Фильтрация по городу в пустом списке")
    void shouldReturnEmptyList_whenListIsEmpty() {
        List<Student> students = studentList.getStudentsFromSpecificCity("Москва");

        assertThat(students)
                .isEmpty();
    }

    @Test
    @DisplayName("getStudentsFromSpecificCity возвращает новую неизменяемую коллекцию")
    void shouldReturnImmutableList() {
        Student ivan = new Student("Иван", "Москва");
        studentList.addStudent(ivan);

        List<Student> result = studentList.getStudentsFromSpecificCity("Москва");

        assertThat(result)
                .isInstanceOf(List.class)
                .isUnmodifiable(); // проверяет, что коллекция неизменяема
    }

    @Test
    @DisplayName("Добавление нескольких студентов — все корректно хранятся")
    void shouldStoreAllStudents() {
        Student ivan = new Student("Иван", "Москва");
        Student maria = new Student("Мария", "Санкт-Петербург");
        Student petr = new Student("Пётр", "Казань");

        studentList.addStudent(ivan);
        studentList.addStudent(maria);
        studentList.addStudent(petr);

        List<Student> moscowStudents = studentList.getStudentsFromSpecificCity("Москва");
        List<Student> spbStudents = studentList.getStudentsFromSpecificCity("Санкт-Петербург");
        List<Student> kazanStudents = studentList.getStudentsFromSpecificCity("Казань");

        assertThat(moscowStudents)
                .containsExactly(ivan);
        assertThat(spbStudents)
                .containsExactly(maria);
        assertThat(kazanStudents)
                .containsExactly(petr);
    }

    @Test
    @DisplayName("Студенты с одинаковым именем, но разным городом — различаются")
    void shouldDistinguishStudentsWithSameNameButDifferentCity() {
        Student ivanMoscow = new Student("Иван", "Москва");
        Student ivanSpb = new Student("Иван", "Санкт-Петербург");

        studentList.addStudent(ivanMoscow);
        studentList.addStudent(ivanSpb);

        List<Student> moscowStudents = studentList.getStudentsFromSpecificCity("Москва");
        List<Student> spbStudents = studentList.getStudentsFromSpecificCity("Санкт-Петербург");

        assertThat(moscowStudents)
                .hasSize(1)
                .containsExactly(ivanMoscow);
        assertThat(spbStudents)
                .hasSize(1)
                .containsExactly(ivanSpb);
    }
}