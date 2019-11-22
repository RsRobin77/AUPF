package room.database.events;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import room.database.utils.DatabaseHelper;

@Entity(tableName = DatabaseHelper.DAILY_EVENT_TABLE, primaryKeys = {"day", "event"})
public class DailyEvent {

    private int id;

    @NonNull
    private String day;

    private String startTime;

    private String endTime;

    @NonNull
    private String event;

    public DailyEvent(@NonNull String day, String startTime, String endTime, @NonNull String event) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return " - " + endTime;
    }

    @NonNull
    public String getEvent() {
        return event;
    }
}
