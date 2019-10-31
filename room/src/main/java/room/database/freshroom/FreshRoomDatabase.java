package room.database.freshroom;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import room.database.CarnivalDao;
import room.database.events.DailyEvent;
import room.database.utils.DatabaseHelper;
import room.database.volunteer.Volunteer;

@Database(entities = {FreshRoom.class, Volunteer.class, DailyEvent.class}, version = DatabaseHelper.DATABASE_VERSION)
public abstract class FreshRoomDatabase extends RoomDatabase {

    private static String Building[] = {"Academic Building-4", "Auditorium", "Auditorium", "Academic Building-1", "Academic Building-1", "Academic Building-1", "Academic Building-1", "Academic Building-3", "Academic Building-3"};
    private static String Floor[] = {"1st floor (Students and Faculty [male])", "Left- Male", "Right-Female", "Ground Floor (Female)", "1st Floor (Male)", "1st Floor West (Deans, Professors and Directors)", "3rd and 4th Floor (Students and Faculty [Female])", "Ground Floor (male)", "1st Floor (Faculty and Admin [male])"};


    private static FreshRoomDatabase instance;
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    static synchronized FreshRoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FreshRoomDatabase.class,
                    DatabaseHelper.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }

        return instance;
    }

    abstract CarnivalDao carnivalDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private CarnivalDao carnivalDao;

        PopulateDbAsyncTask(FreshRoomDatabase db) {
            carnivalDao = db.carnivalDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < Floor.length; i++) {
                carnivalDao.insertFreshRoom(new FreshRoom(Floor[i], Building[i]));
            }
            return null;
        }
    }
}
