package ru.mentee.power.devtools.progress;

public class ProgressTracker {

    /**
     * Суммарный прогресс группы mentee.
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        int totalLessonsCompleted = 0;
        int totalLessons = 0;

        for (Mentee mentee : mentees) {
            totalLessonsCompleted += mentee.completedLessons();
            totalLessons += mentee.totalLessons();
        }
        return "Суммарно: пройдено %d из %d уроков, осталось %d уроков"
                .formatted(totalLessonsCompleted, totalLessons,
                        totalLessons - totalLessonsCompleted);
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