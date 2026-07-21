package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenteeTest {

    @Test
    void shouldCreateMentee_whenValidData() {
        Mentee mentee = new Mentee("Иван", "Москва", "Backend", 5, 12);

        assertThat(mentee.name()).isEqualTo("Иван");
        assertThat(mentee.city()).isEqualTo("Москва");
        assertThat(mentee.goal()).isEqualTo("Backend");
        assertThat(mentee.completedLessons()).isEqualTo(5);
        assertThat(mentee.totalLessons()).isEqualTo(12);
    }

    @Test
    void shouldThrowException_whenCompletedLessonsNegative() {
        assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", -1, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    void shouldThrowException_whenTotalLessonsZeroOrNegative() {
        assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 0, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    void shouldThrowException_whenCompletedLessonsGreaterThanTotal() {
        assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 15, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    void shouldNotThrowException_whenValidData() {
        assertThatCode(() -> new Mentee("Иван", "Москва", "Backend", 5, 12))
                .doesNotThrowAnyException();
    }
}