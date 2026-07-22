package ru.mentee.power.devtools;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {

    @Test
    void shouldFormatSummary_whenProgressCreated() {
        MenteeProgress progress = new MenteeProgress("Артем", 1, 20);

        String result = progress.summary();

        assertThat(result).isEqualTo("Sprint 1 → Артем: planned 20 h");
    }

    @Test
    void shouldDetectReadiness_whenHoursAboveThreshold() {
        MenteeProgress progress = new MenteeProgress("Артем", 1, 20);

        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
        MenteeProgress progress = new MenteeProgress("Артем", 1, 15);

        assertThat(progress.readyForSprint()).isFalse();
    }
}