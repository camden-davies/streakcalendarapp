package com.streakapp.calendar.TEST;

import java.util.*;

import com.streakapp.calendar.service.CalendarService;

public class TestRunner  {

    public static void main(String[] args) {
        CalendarService cs = new CalendarService();
        cs.createStreak("Gym", "Red", 3, "week");
        System.out.println("Streak created. Complete a task to start the timer.");
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
            cs.completeTask(1);
        }
    }
}
