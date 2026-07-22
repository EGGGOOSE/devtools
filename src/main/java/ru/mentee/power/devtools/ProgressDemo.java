package ru.mentee.power.devtools;

public class ProgressDemo {

    public static void runDemo(String name, int sprint, int hours) {
        var progress = new MenteeProgress(
                name,   // возьми значение из своего плана PLAN-2
                sprint, // номер спринта
                hours   // запланированные часы на спринт
        );

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }

        IO.println("Current branch: feature/DVT-3");
    }

    public static void main(String[] args) {
        runDemo("Артем", 2, 21);
    }
}