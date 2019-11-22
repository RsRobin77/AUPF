package room.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import room.database.events.DailyEvent;
import room.database.freshroom.FreshRoom;
import room.database.utils.DatabaseHelper;
import room.database.volunteer.Volunteer;

@Database(entities = {FreshRoom.class, Volunteer.class, DailyEvent.class}, version = DatabaseHelper.DATABASE_VERSION)
public abstract class CarnivalDatabase extends RoomDatabase {

    public static CarnivalDatabase instance;
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

   public static synchronized CarnivalDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CarnivalDatabase.class,
                    DatabaseHelper.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }

        return instance;
    }

    public abstract CarnivalDao carnivalDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private CarnivalDao carnivalDao;

        PopulateDbAsyncTask(CarnivalDatabase db) {
            carnivalDao = db.carnivalDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            carnivalDao.deleteAllEvents();
            carnivalDao.deleteAllFreshRoom();
            carnivalDao.deleteAllVolunteer();
            return null;
        }
    }
}
