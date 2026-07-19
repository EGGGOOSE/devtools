package ru.mentee.power;

public record MenteeProgress(String menteeName, int sprintNumber, int plannedHoursPerWeek) {

    public boolean readyForSprint() {
        return plannedHoursPerWeek >= 20;
    }

    public String summary() {
        String string = "Sprint %d → %s: planned %d h";
        return string.formatted(sprintNumber, menteeName, plannedHoursPerWeek);
    }
}