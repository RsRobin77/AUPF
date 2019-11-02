package room.database.events;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import room.database.utils.DatabaseHelper;

@Entity(tableName = DatabaseHelper.DAILY_EVENT_TABLE)
public class DailyEvent {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String day;

    private String startTime;

    private String endTime;

    private String event;

    public DailyEvent(String day, String startTime, String endTime, String event) {
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

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return " - " + endTime;
    }

    public String getEvent() {
        return event;
    }
}
