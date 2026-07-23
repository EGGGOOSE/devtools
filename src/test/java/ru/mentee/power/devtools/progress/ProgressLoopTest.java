package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {

    @Test
    @DisplayName("Суммарный прогресс для нескольких mentee с разным прогрессом")
    void shouldCalculateTotalProgress_whenMultipleMentees() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 25 из 36 уроков")
                .contains("осталось 11 уроков");
    }

    @Test
    @DisplayName("Все mentee завершили курс — осталось 0")
    void shouldCalculateTotalProgress_whenAllMenteesCompleted() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 12, 12),
                new Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 24 из 24 уроков")
                .contains("осталось 0 уроков");
    }

    @Test
    void shouldPrintCorrectAnswer_whenValidData() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ProgressTracker.runDemo(new Mentee[]{
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        });

        System.setOut(System.out);
        assertThat(out.toString())
                .contains("Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков");
    }

    @Test
    @DisplayName("Пустой массив mentee — возвращает корректное сообщение")
    void shouldHandleEmptyMenteeArray() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] emptyArray = {};

        String result = tracker.calculateTotalProgress(emptyArray);

        assertThat(result)
                .contains("пройдено 0 из 0 уроков")
                .contains("осталось 0 уроков");
    }

    @Test
    @DisplayName("Null — выбрасывает IllegalArgumentException")
    void shouldThrowException() {
        ProgressTracker tracker = new ProgressTracker();
        assertThatThrownBy(()->tracker.calculateTotalProgress(null))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Массив mentees не может быть null");
    }
}
