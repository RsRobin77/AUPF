package room.database.freshroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FreshRoomViewModel extends AndroidViewModel {

    private FreshRoomRepository freshRoomRepository;
    private LiveData<List<FreshRoom>> allFreshRooms;

    public FreshRoomViewModel(@NonNull Application application) {
        super(application);

        freshRoomRepository = new FreshRoomRepository(application);
        allFreshRooms = freshRoomRepository.getAllFreshRooms();
    }

    public void insert(FreshRoom freshRoom) {
        freshRoomRepository.insertFreshRoom(freshRoom);
    }

    public LiveData<List<FreshRoom>> getAllFreshRooms() {
        return allFreshRooms;
    }
}
