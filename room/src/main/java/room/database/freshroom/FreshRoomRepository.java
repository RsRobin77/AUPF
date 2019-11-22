package room.database.freshroom;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import room.database.CarnivalDao;
import room.database.CarnivalDatabase;

public class FreshRoomRepository {
    private CarnivalDao carnivalDao;
    private LiveData<List<FreshRoom>> freshRoomList;

    FreshRoomRepository(Application application){
        CarnivalDatabase database = CarnivalDatabase.getInstance(application);
        carnivalDao = database.carnivalDao();
        freshRoomList = carnivalDao.getAllFreshRooms();
    }

    public void insertFreshRoom(FreshRoom freshRoom){
        new InsertFreshRoomTask(carnivalDao).execute(freshRoom);
    }

    public void deleteAllFreshRooms(FreshRoom freshRoom){
        new DeleteAllFreshRooms(carnivalDao).execute(freshRoom);
    }

    public LiveData<List<FreshRoom>> getAllFreshRooms(){
        return freshRoomList;
    }

    private static class InsertFreshRoomTask extends AsyncTask<FreshRoom,Void,Void>{

        private CarnivalDao carnivalDao;

        private InsertFreshRoomTask(CarnivalDao carnivalDao){
            this.carnivalDao = carnivalDao;
        }

        @Override
        protected Void doInBackground(FreshRoom... rooms) {
            carnivalDao.insertFreshRoom(rooms[0]);
            return null;
        }
    }

    private static class DeleteAllFreshRooms extends AsyncTask<FreshRoom,Void,Void>{

        private CarnivalDao carnivalDao;
        private DeleteAllFreshRooms(CarnivalDao carnivalDao){
            this.carnivalDao = carnivalDao;
        }
        @Override
        protected Void doInBackground(FreshRoom... rooms) {
            carnivalDao.deleteAllFreshRoom();
            return null;
        }
    }
}
