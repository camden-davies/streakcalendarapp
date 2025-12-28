package com.streakapp.calendar.timers;

import java.time.LocalDateTime;

public class DayTimer extends BaseTimer {

    public DayTimer(String name, String color, int tasksPerUnit) {
        super(name, color, tasksPerUnit);
    }

    @Override
    protected LocalDateTime computePeriodEnd(LocalDateTime start) {
        return start.toLocalDate().plusDays(1).atStartOfDay();
    }
}

