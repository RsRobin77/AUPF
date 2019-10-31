package room.database.freshroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import room.database.utils.DatabaseHelper;

@Entity(tableName = DatabaseHelper.FRESH_ROOM_TABLE)
public class FreshRoom {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String floor;
    private String building;

    public FreshRoom(String floor, String building) {
        this.floor = floor;
        this.building = building;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFloor() {
        return floor;
    }

    public String getBuilding() {
        return building;
    }
}
