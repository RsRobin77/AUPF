package com.daffodil.varsity.aupf.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffodil.varsity.aupf.R
import room.database.freshroom.FreshRoom
import room.database.freshroom.FreshRoomAdapter
import room.database.freshroom.FreshRoomViewModel

/**
 * A simple [Fragment] subclass.
 */
class FreshRoom : Fragment() {

    private lateinit var freshRoomViewModel: FreshRoomViewModel
    private var noteAdapter: FreshRoomAdapter = FreshRoomAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_fresh_room, container, false)

        freshRoomViewModel = ViewModelProviders.of(this).get(FreshRoomViewModel::class.java)
        freshRoomViewModel.allFreshRooms.observe(this, Observer {
            noteAdapter.submitList(it)
            recyclerView = view.findViewById(R.id.recycler_view)

            if (it.size == 0)
                insert()

            recyclerView.apply {
                hasFixedSize()
                layoutManager = LinearLayoutManager(context)
                adapter = noteAdapter
            }
        })

        return view
    }

    private fun insert() {

        val building = arrayOf("Academic Building-4", "Auditorium", "Auditorium", "Academic Building-1", "Academic Building-1", "Academic Building-1", "Academic Building-1", "Academic Building-3", "Academic Building-3")
        val floor = arrayOf("1st floor (Students and Faculty [male])", "Left- Male", "Right-Female", "Ground Floor (Female)", "1st Floor (Male)", "1st Floor West (Deans, Professors and Directors)", "3rd and 4th Floor (Students and Faculty [Female])", "Ground Floor (male)", "1st Floor (Faculty and Admin [male])")

        for (i in floor.indices) {
            freshRoomViewModel.insert(FreshRoom(floor[i], building[i]))
        }

    }

}
