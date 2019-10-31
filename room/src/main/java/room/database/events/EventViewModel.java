package room.database.events;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private EventRepository repository;

    public EventViewModel(@NonNull Application application) {
        super(application);
        repository = new EventRepository(application);

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
