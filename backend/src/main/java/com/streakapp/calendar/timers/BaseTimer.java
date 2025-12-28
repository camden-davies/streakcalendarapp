package com.streakapp.calendar.timers;

import com.streakapp.calendar.model.StreakItem;
import com.streakapp.calendar.model.Unit;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public abstract class BaseTimer extends StreakItem implements TimerInterface {

    protected final Unit unit;
    private Timer timer;

    protected LocalDateTime periodStart;
    protected LocalDateTime periodEnd;

    protected BaseTimer(String name, String color, int tasksPerUnit) {
        super(name, color, tasksPerUnit);
        this.unit = new Unit(tasksPerUnit);
    }

    // For subclasses to implement specific periods
    protected abstract LocalDateTime computePeriodEnd(LocalDateTime start);

    @Override
    public void startTimer() {
        if (timer != null) return; // prevent double-start

        periodStart = LocalDateTime.now();
        periodEnd = computePeriodEnd(periodStart);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long remaining = Duration.between(LocalDateTime.now(), periodEnd).getSeconds();

                // Optional debug print:
                System.out.println(getClass().getSimpleName() + " remaining: " + Math.max(0, remaining) + "s"); // DEBUG

                if (remaining <= 0) {
                    timer.cancel();
                    timer = null; // allow restart
                    onTimerFinished();
                }
            }
        }, 0, 1000);
    }

    public void onTimerFinished() {
        System.out.println("Period has ended.");
        if (unit.isComplete()) {
            System.out.println("All tasks completed for this period.");
            this.addStreak();
            unit.resetTasks();
            startTimer();
        } else {
            System.out.println("Not all tasks completed for this period.");
            unit.resetTasks();
            this.resetStreak();
        }
    }

    public void completeTask() {
        unit.completeTask();
    }
}

