package room.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import room.database.events.DailyEvent;
import room.database.freshroom.FreshRoom;
import room.database.volunteer.Volunteer;

@Dao
public interface CarnivalDao {

    /**
     * THIS IS THE [VOLUNTEER] DAO SECTION. WHERE A VOLUNTEER CAN BE ADDED,UPDATED AND DELETED .
     * ALSO CAN DELETE ALL THE VOLUNTEER OR CAN GET LIST OF THE VOLUNTEER.
     */

    @Insert
    void insertVolunteer(Volunteer volunteer);

    @Update
    void updateVolunteer(Volunteer volunteer);

    @Delete
    void deleteVolunteer(Volunteer volunteer);

    @Query("DELETE FROM volunteer_table WHERE volunteerName")
    void deleteAllVolunteer();

    @Query("SELECT * FROM volunteer_table ORDER BY dept AND campus AND volunteerName")
    LiveData<List<Volunteer>> getAllVolunteers();


    /**
     * THIS IS THE [FRESH ROOM] DAO SECTION. WHERE THE FRESH ROOM CAN BE ADD,REMOVE AND GET ALL THE ROOM LISTS
     */
    @Insert
    void insertFreshRoom(FreshRoom freshRoom);

    @Query("DELETE FROM fresh_room")
    void deleteAllFreshRoom();

    @Query("SELECT * FROM fresh_room ORDER BY building AND floor")
    LiveData<List<FreshRoom>> getAllFreshRooms();

    /**
     * this section is for the management of [daily events]. Where the event is going for day1, day2 and day3.
     * The query is for different day wise programs.
     */

    @Insert
    void insertDailyEvents(DailyEvent dailyEvent);

    @Query("DELETE FROM daily_event")
    void deleteAllEvents();

    @Query("SELECT * FROM daily_event WHERE day = :day")
    LiveData<List<DailyEvent>> getAllEvents(String day);

}
