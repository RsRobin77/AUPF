package room.database.events;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import room.database.CarnivalDao;
import room.database.freshroom.FreshRoom;
import room.database.utils.DatabaseHelper;
import room.database.volunteer.Volunteer;

@Database(entities = {FreshRoom.class, Volunteer.class, DailyEvent.class}, version = DatabaseHelper.DATABASE_VERSION)
public abstract class EventDatabase extends RoomDatabase {

    private static EventDatabase instance;

    private static RoomDatabase.Callback roomCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

    };

    static synchronized EventDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    EventDatabase.class,
                    DatabaseHelper.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }

        return instance;
    }

    abstract CarnivalDao carnivalDao();

}
