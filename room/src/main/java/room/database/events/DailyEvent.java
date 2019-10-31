package room.database.events;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import room.database.utils.DatabaseHelper;

@Entity(tableName = DatabaseHelper.DAILY_EVENT_TABLE)
public class DailyEvent {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String startTime;

    private String endTime;

    private String event;

    public DailyEvent(String startTime, String endTime, String event) {
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

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        if (endTime.isEmpty())
            return endTime;
        else return " - " + endTime;
    }

    public String getEvent() {
        return event;
    }
}
