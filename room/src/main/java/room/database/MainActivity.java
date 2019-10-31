package room.database;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import room.database.volunteer.VolunteerViewModel;
import room.database.volunteer.OnRecyclerViewItemClickListener;
import room.database.volunteer.Volunteer;
import room.database.volunteer.VolunteerAdapter;

public class MainActivity extends AppCompatActivity {

    private VolunteerViewModel noteViewModel;

    private VolunteerAdapter adapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new VolunteerAdapter();

        noteViewModel = ViewModelProviders.of(this).get(VolunteerViewModel.class);
        noteViewModel.getAllVolunteers().observe(this, new Observer<List<Volunteer>>() {
            @Override
            public void onChanged(List<Volunteer> notes) {

                adapter.submitList(notes);
                recyclerView.setAdapter(adapter);

            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.delete(adapter.getVolunteerAt(viewHolder.getAdapterPosition()));

                Toast.makeText(MainActivity.this, "Volunteer Deleted!", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Volunteer note) {

            }
        });
    }


}
