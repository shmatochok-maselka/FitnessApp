package com.example.thirdfemalefitness;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;

public class EventEditActivity extends AppCompatActivity {
    private EditText eventNameET;
    private TextView eventDateTV;
    TimePicker eventTimePick;
    public static int notificationId = 1;
    private NotificationManagerCompat notificationManager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);

        notificationManager = NotificationManagerCompat.from(this);
        initWidgets();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        eventTimePick = findViewById(R.id.timePicker);
        int hour = eventTimePick.getCurrentHour();
        int minute = eventTimePick.getCurrentMinute();
        addReminder(hour, minute, eventName);
        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, LocalTime.of(hour, minute));
        Event.eventsList.add(newEvent);
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addReminder(int hour, int minute, String workoutName)
    {
        String remindMessage = "Time to do workouts!";
        if (workoutName.length() != 0) {
            remindMessage = workoutName;
        }

        Intent intent = new Intent(EventEditActivity.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("message", remindMessage);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                EventEditActivity.this, notificationId, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);


        Calendar startTime = Calendar.getInstance();
        Instant instant = CalendarUtils.selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        long timeInMillis = instant.toEpochMilli();
        startTime.setTimeInMillis(timeInMillis);
        startTime.set(Calendar.HOUR_OF_DAY, hour);
        startTime.set(Calendar.MINUTE, minute);
        startTime.set(Calendar.SECOND, 0);


        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, startTime.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

        Toast.makeText(EventEditActivity.this, "Reminder added!", Toast.LENGTH_SHORT).show();
        notificationId += 1;
    }
}