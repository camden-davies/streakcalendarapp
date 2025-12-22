package com.streakapp.calendar.TEST;

import com.streakapp.calendar.timers.BaseTimer;

public class TestTimer extends BaseTimer {

    protected TestTimer(String name, String color, int tasksPerUnit) {
        super(name, color, tasksPerUnit);
    }

    @Override
    protected java.time.LocalDateTime computePeriodEnd(java.time.LocalDateTime start) {
        return start.plusSeconds(10);
    }
}
