package room.database.volunteer;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import room.database.CarnivalDao;

public class VolunteerRepository {

    private CarnivalDao carnivalDao;
    private LiveData<List<Volunteer>> allVolunteers;

    public VolunteerRepository(Application application) {
        VolunteerDatabase database = VolunteerDatabase.getInstance(application);
        carnivalDao = database.carnivalDao();
        allVolunteers = carnivalDao.getAllVolunteers();

    }

    public void insert(Volunteer note) {
        new InsertNoteAsyncTask(carnivalDao).execute(note);
    }

    public void update(Volunteer note) {
        new UpdateVolunteerAsyncTask(carnivalDao).execute(note);
    }

    public void delete(Volunteer note) {
        new DeleteVolunteerAsyncTask(carnivalDao).execute(note);
    }

    public void deleteAllVolunteers() {
        new DeleteAllVolunteerAsyncTask(carnivalDao).execute();
    }

    public LiveData<List<Volunteer>> getAllVolunteers() {
        return allVolunteers;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Volunteer, Void, Void> {

        private CarnivalDao carnivalDao;

        private InsertNoteAsyncTask(CarnivalDao carnivalDao) {
            this.carnivalDao = carnivalDao;
        }

        @Override
        protected Void doInBackground(Volunteer... notes) {
            carnivalDao.insertVolunteer(notes[0]);
            return null;

        }
    }

    private static class UpdateVolunteerAsyncTask extends AsyncTask<Volunteer, Void, Void> {

        private CarnivalDao carnivalDao;

        private UpdateVolunteerAsyncTask(CarnivalDao carnivalDao) {
            this.carnivalDao = carnivalDao;
        }

        @Override
        protected Void doInBackground(Volunteer... volunteers) {
            carnivalDao.updateVolunteer(volunteers[0]);
            return null;

        }
    }

    private static class DeleteVolunteerAsyncTask extends AsyncTask<Volunteer, Void, Void> {

        private CarnivalDao carnivalDao;

        private DeleteVolunteerAsyncTask(CarnivalDao carnivalDao) {
            this.carnivalDao = carnivalDao;
        }

        @Override
        protected Void doInBackground(Volunteer... volunteers) {
            carnivalDao.deleteVolunteer(volunteers[0]);
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
            carnivalDao.deleteAllVolunteer();
            return null;

        }
    }

}
