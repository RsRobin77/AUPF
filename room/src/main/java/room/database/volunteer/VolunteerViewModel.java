package room.database.volunteer;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class VolunteerViewModel extends AndroidViewModel {

    private VolunteerRepository repository;
    private LiveData<List<Volunteer>> allVolunteers;

    public VolunteerViewModel(@NonNull Application application) {
        super(application);

        repository = new VolunteerRepository(application);
        allVolunteers = repository.getAllVolunteers();
    }

    public void insert(Volunteer volunteer) {
        repository.insert(volunteer);
    }

    public void update(Volunteer volunteer) {
        repository.update(volunteer);
    }

    public void delete(Volunteer volunteer) {
        repository.delete(volunteer);
    }

    public void deleteAllVolunteers() {
        repository.deleteAllVolunteers();
    }

    public LiveData<List<Volunteer>> getAllVolunteers() {
        return allVolunteers;
    }
}
