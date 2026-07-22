package ru.mentee.power.devtools.progress;

public class ProgressTracker {

    /**
     * Суммарный прогресс группы mentee.
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        int index = 0;
        int totalCompleted = 0;
        int totalTotal = 0;

        while (index < mentees.length) {
            totalCompleted += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
        }
        return "Суммарно: пройдено %d из %d уроков, осталось %d уроков"
                .formatted(totalCompleted, totalTotal, totalTotal - totalCompleted);
    }

    public static void runDemo(Mentee[] mentees) {
        System.out.println(new ProgressTracker().calculateTotalProgress(mentees));
    }

    public static void main(String[] args) {
        runDemo(new Mentee[]{
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        });
    }
}