package ru.mentee.power.devtools;

public class ProgressDemo {

    public static void runDemo(String name, int sprint, int hours) {
        var progress = new MenteeProgress(
                name,
                sprint,
                hours
        );

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }

    public static void main(String[] args) {
        runDemo("Артем", 2, 21);
    }
}