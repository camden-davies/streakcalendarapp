package com.streakapp.calendar.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.streakapp.calendar.timers.TimerInterface;
import com.streakapp.calendar.timers.DayTimer;
import com.streakapp.calendar.timers.WeekTimer;
import com.streakapp.calendar.timers.MonthTimer;


@Service
public class CalendarService {

    private final Map<Integer, TimerInterface> streaks = new HashMap<>();

    public void createStreak(String name, String color, int tasksPerUnit, String unit) {

        TimerInterface streak = switch (unit.toUpperCase()) {
            case "DAY" -> new DayTimer(name, color, tasksPerUnit);
            case "WEEK" -> new WeekTimer(name, color, tasksPerUnit);
            case "MONTH" -> new MonthTimer(name, color, tasksPerUnit);
            //case "TENSEC" -> new TestTimer(name, color, tasksPerUnit); // TEST
            default -> throw new IllegalArgumentException("Invalid unit: " + unit);
        };

        streaks.put(streak.getId(), streak);
    }

    public void completeTask(int id) {
        TimerInterface streak = streaks.get(id);
        // If implement dropdown menu, remove
        if (streak == null)
            throw new IllegalArgumentException("No streak found with id: " + id);
        if (streak.getStreak() == 0)
            streak.startTimer();
        streak.completeTask();
    }


    public List<TimerInterface> listStreaks() {
        return List.copyOf(streaks.values());
    }

    public TimerInterface getStreak(int id) {
        TimerInterface streak = streaks.get(id);
        if (streak == null)
            throw new IllegalArgumentException("No streak found with id: " + id);
        return streak;
    } 
}
