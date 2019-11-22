package room.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import room.database.CarnivalDao;
import room.database.CarnivalDatabase;
import room.database.events.DailyEvent;

public class CarnivalRepository {

    private CarnivalDao carnivalDao;

    public CarnivalRepository(Application application) {
        CarnivalDatabase database = CarnivalDatabase.getInstance(application);

        carnivalDao = database.carnivalDao();
    }

    public LiveData<List<DailyEvent>> getDailyEvents(String day) {
        return carnivalDao.getAllEvents(day);
    }

    public void insert(DailyEvent dailyEvent) {
        new InsertNoteAsyncTask(carnivalDao).execute(dailyEvent);
    }

    public void deleteAll() {
        new DeleteAllVolunteerAsyncTask(carnivalDao).execute();
    }

    private static class InsertNoteAsyncTask extends AsyncTask<DailyEvent, Void, Void> {

        private CarnivalDao carnivalDao;

        private InsertNoteAsyncTask(CarnivalDao carnivalDao) {
            this.carnivalDao = carnivalDao;
        }

        @Override
        protected Void doInBackground(DailyEvent... events) {
            carnivalDao.insertDailyEvents(events[0]);
            return null;

        }
    }

    private static class DeleteAllVolunteerAsyncTask extends AsyncTask<Void, Void, Void> {

        private CarnivalDao carnivalDao;

        private DeleteAllVolunteerAsyncTask(CarnivalDao carnivalDao) {
            this.carnivalDao = carnivalDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            carnivalDao.deleteAllEvents();
            return null;

        }
    }


}
