package com.streakapp.calendar.timers;

import java.time.LocalDateTime;

public class MonthTimer extends BaseTimer {

    public MonthTimer(String name, String color, int tasksPerUnit) {
        super(name, color, tasksPerUnit);
    }

    @Override
    protected LocalDateTime computePeriodEnd(LocalDateTime start) {
        return start.toLocalDate().withDayOfMonth(1).plusMonths(1).atStartOfDay();
    }
}
