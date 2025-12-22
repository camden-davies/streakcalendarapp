package com.streakapp.calendar.timers;

import java.time.LocalDateTime;

public interface TimerInterface {
    void startTimer();
    void onTimerFinished();
    void completeTask();
    int getId();
    int getStreak();
    LocalDateTime getPeriodStart();
    LocalDateTime getPeriodEnd();
}
