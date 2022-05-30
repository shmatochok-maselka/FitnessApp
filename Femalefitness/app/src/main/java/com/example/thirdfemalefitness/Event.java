package com.example.thirdfemalefitness;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Event {
    public static ArrayList<Event> eventsList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }
        Collections.sort(events, new Comparator<Event>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            public int compare(Event o1, Event o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        return events;
    }


    private String name;
    private LocalDate date;
    private LocalTime time;

    public Event(String name, LocalDate date, LocalTime time)
    {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
}
