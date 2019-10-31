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
import room.database.events.DailyEvent
import room.database.events.EventAdapter
import room.database.events.EventViewModel


/**
 * A [Fragment] of Daily Event lists. Where the list of events in a day will be shown here.
 */
class DailyEvents : Fragment() {
    private lateinit var eventViewModel: EventViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_daily_events, container, false)

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel::class.java)

        eventViewModel.allEvents.observe(this, Observer { events ->
            val recyclerView = rootView.findViewById<RecyclerView>(R.id.daily_events)

            if (events.size == 0)
                insert()

            val eventAdapter = EventAdapter()
            eventAdapter.submitList(events)

            recyclerView.apply {
                hasFixedSize()
                layoutManager = LinearLayoutManager(context)
                adapter = eventAdapter
            }
        })


        return rootView
    }

    private fun insert() {
        val startTime = arrayOf(
                "7.00 am",
                "9.00 am",
                "10.00 am",
                "10.05 am",
                "10.10 am",
                "10.15 am",
                "10.35 am",
                "10.40 am",
                "11.00 am",
                "2.00 pm",
                "3.00 pm",
                "4.00 pm",
                "5.00 pm",
                "5.10 pm",
                "5.20 pm",
                "5.30")

        val endTime = arrayOf(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "2.00 pm",
                "3.00 pm",
                "4.00 pm",
                "5.30 pm",
                "",
                "",
                "",
                "")

        val eventName = arrayOf("Departure from Main Campus to Permanent Campus\n",
                "Preparation and setup all the Projects\n",
                "The arrival of the Guests\n",
                "Quran Telwat\n",
                "Welcome Speech by the Convener of ICT Carnival 2019\n",
                "Inauguration Speech by Hon’ble Chairman, BoT, Daffodil Family\n",
                "Session of the Chair by Hon’ble Vice-Chancellor, DIU\n",
                "Launching of ICT Carnival 2019\n",
                "Project Showcase and visit of Jury members\n",
                "Lunch Break\n",
                "Project Showcase and visit of Jury members\n",
                "Award Giving Ceremony\n",
                "Group Photo Session\n",
                "Speech by Chief Guest\n",
                "Closing Speech by Prof. Dr. Syed Akhter Hossain\n",
                "Departure to Main Campus of DIU\n")


        for (i in eventName.indices)
            eventViewModel.insert(DailyEvent(startTime[i].trim(), endTime[i].trim(), eventName[i].trim()))
    }

}
