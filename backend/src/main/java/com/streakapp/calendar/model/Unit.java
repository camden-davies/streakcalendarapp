package com.streakapp.calendar.model;

public class Unit {
    int tasksPerUnit;
    int completedTasks = 0;

    public Unit(int tasksPerUnit) {
        this.tasksPerUnit = tasksPerUnit;
    }

    public void completeTask() {
        completedTasks++;
        // System.out.println("\u001B[32m" + "Task completed" + "\u001B[0m"); // TEST
    }

    public boolean isComplete() {
        return completedTasks >= tasksPerUnit;
    }

    public void resetTasks() {
        this.completedTasks = 0;
        // System.out.println("Tasks reset"); // TEST
    }

    public int getTasksRemaining() {
        return Math.max(0, tasksPerUnit - completedTasks);
    }
}
