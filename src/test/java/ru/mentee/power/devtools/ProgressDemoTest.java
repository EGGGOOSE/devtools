package ru.mentee.power.devtools;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class ProgressDemoTest {

    @Test
    void shouldPrintReadyStatus_whenHoursEnough() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ProgressDemo.runDemo("Тест", 1, 20);

        System.setOut(System.out);
        assertThat(out.toString())
                .contains("Status: sprint ready");
    }

    @Test
    void shouldPrintBacklogFirst_whenHoursNotEnough() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ProgressDemo.runDemo("Тест", 1, 19);

        System.setOut(System.out);
        assertThat(out.toString())
                .contains("Status: backlog first");
    }
}