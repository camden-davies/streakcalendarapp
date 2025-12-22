package com.streakapp.calendar.timers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeekTimer extends BaseTimer {

    public WeekTimer(String name, String color, int tasksPerUnit) {
        super(name, color, tasksPerUnit);
    }

    @Override
    protected LocalDateTime computePeriodEnd(LocalDateTime start) {
        LocalDate d = start.toLocalDate();

        // end = next Monday at 00:00 (week starts Monday)
        int daysUntilNextMonday = (DayOfWeek.MONDAY.getValue() - d.getDayOfWeek().getValue() + 7) % 7;
        if (daysUntilNextMonday == 0) daysUntilNextMonday = 7;

        return d.plusDays(daysUntilNextMonday).atStartOfDay();
    }
}
