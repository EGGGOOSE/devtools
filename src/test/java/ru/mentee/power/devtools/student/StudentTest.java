package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование Student (record)")
class StudentTest {

    @Test
    @DisplayName("Создание студента с именем и городом")
    void shouldCreateStudentWithNameAndCity() {
        Student student = new Student("Иван", "Москва");

        assertThat(student)
                .extracting(Student::name, Student::city)
                .containsExactly("Иван", "Москва");
    }

    @Test
    @DisplayName("Два студента с одинаковыми данными должны быть равны")
    void shouldBeEqual_whenSameNameAndCity() {
        Student student1 = new Student("Мария", "Санкт-Петербург");
        Student student2 = new Student("Мария", "Санкт-Петербург");

        assertThat(student1)
                .isEqualTo(student2)
                .hasSameHashCodeAs(student2);
    }

    @Test
    @DisplayName("Студенты с разными данными не должны быть равны")
    void shouldNotBeEqual_whenDifferentNameOrCity() {
        Student student1 = new Student("Пётр", "Казань");
        Student student2 = new Student("Пётр", "Москва");
        Student student3 = new Student("Алексей", "Казань");

        assertThat(student1)
                .isNotEqualTo(student2)
                .isNotEqualTo(student3);
    }

    @Test
    @DisplayName("toString должен возвращать корректное представление")
    void shouldHaveCorrectToString() {
        Student student = new Student("Ольга", "Новосибирск");

        assertThat(student.toString())
                .isEqualTo("Student[name=Ольга, city=Новосибирск]");
    }
}