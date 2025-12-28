package com.streakapp.calendar.model;

import java.time.LocalDateTime;

public abstract class StreakItem {
    private final String name; // Name of the streak
    private final String color; // Color of the streak
    private static int count = 0; // Number of streak items created
    private final int id; // Unique identifier for the streak item
    private int streak; // Current streak count
    protected int tasksPerUnit; // Number of tasks required to complete the time unit
    protected LocalDateTime periodStart;
    protected LocalDateTime periodEnd;

    public StreakItem(String name, String color, int tasksPerUnit) {
        this.name = name;
        this.color = color;
        this.id = ++count;
        this.streak = 0;
        this.tasksPerUnit = tasksPerUnit;
    }



    public void resetStreak() {
        System.out.println("\u001B[31m" + "Streak Ended" + "\u001B[0m");   // TEST
        streak = 0;
    }

    public void addStreak() {
        System.out.println("\u001B[32m" + "Streak Increased" + "\u001B[0m");   // TEST
        streak += 1;
    }

    public int getStreak() {
        return streak;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public LocalDateTime getPeriodStart() {
        return periodStart;
    }

    public LocalDateTime getPeriodEnd() {
        return periodEnd;
    }
}
