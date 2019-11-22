package room.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import room.database.events.DailyEvent;

public class CarnivalViewModel extends AndroidViewModel {

    private CarnivalRepository repository;

    public CarnivalViewModel(@NonNull Application application) {
        super(application);
        repository = new CarnivalRepository(application);

    }

    public void insert(DailyEvent dailyEvent) {
        repository.insert(dailyEvent);
    }

    public LiveData<List<DailyEvent>> getAllEvents(String day) {
        return repository.getDailyEvents(day);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
