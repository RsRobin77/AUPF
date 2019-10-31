package com.daffodil.varsity.aupf.ui.fragment.tabs

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

private const val DAY = "param1"

class EventsTab : Fragment() {

    private var day: String? = null
    private lateinit var eventViewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            day = it.getString(DAY)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel::class.java)

        eventViewModel.getAllEvents(day).observe(this, Observer {
            val eventAdapter = EventAdapter()
            eventAdapter.submitList(it)
            val recyclerView = view!!.findViewById<RecyclerView>(R.id.recycler_view)

            if (it.isEmpty()) {
                when (day) {
                    "day1" -> day1()

                    "day2" -> day2()

                    "day3" -> day3()
                }
            }

            recyclerView.apply {
                hasFixedSize()
                layoutManager = LinearLayoutManager(context)
                adapter = eventAdapter
            }
        })

        return inflater.inflate(R.layout.fragment_event_tabs, container, false)
    }


    private fun day1() {
        val startTime = arrayOf(
                "10:00",
                "17:30",
                "18:00"
        )

        val endTime = arrayOf(
                "16:30",
                "18:00",
                "20:00")

        val eventName = arrayOf("City Tour (Complementary)\n" ,
                "Formal Reception \n" ,
                "Welcome Dinner\n")

        val day = "day1"

        for (i in eventName.indices)
            eventViewModel.insert(DailyEvent(day, startTime[i].trim(), endTime[i].trim(), eventName[i].trim()))
    }

    private fun day2() {
        val startTime = arrayOf(

                "09:00" ,
                        "10:30" ,
                        "12:00" ,
                        "13:30" ,
                        "15:30" ,
                        "17:30"
        )

        val endTime = arrayOf(

                "10:30\n" ,
                        "12:00\n" ,
                        "13:30\n" ,
                        "15:00\n" ,
                        "17:00\n" ,
                        "19:30\n"
        )

        val eventName = arrayOf(
                "Opening Ceremony, Keynote\n" ,
                        "Parallel Session 1\n",
                        "Lunch\n" ,
                        "Parallel Session 2\n",
                        "Parallel Session 3\n",
                        "Dinner\n"
        )

        val day = "day2"

        for (i in eventName.indices)
            eventViewModel.insert(DailyEvent(day, startTime[i].trim(), endTime[i].trim(), eventName[i].trim()))
    }

    private fun day3() {
        val startTime = arrayOf(
                "08:00" ,
                        "09:00" ,
                        "11:00" ,
                        "12:00" ,
                        "14:00"
        )

        val endTime = arrayOf(
                "09:00\n" ,
                        "10:30\n" ,
                        "12:00\n" ,
                        "13:00\n" ,
                        "17:00\n"
        )

        val eventName = arrayOf(
                "Standing Committee Meeting\n",
                        "MOU Signing\n" ,
                        "Closing Ceremony\n" ,
                        "Farewell Lunch\n" ,
                        "Playing Golf (Complementary)\n"
        )

        val day = "day3"


        for (i in eventName.indices)
            eventViewModel.insert(DailyEvent(day, startTime[i].trim(), endTime[i].trim(), eventName[i].trim()))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param day Parameter 1.
         * @return A new instance of fragment EventsTab.
         */
        @JvmStatic
        fun newInstance(day: String) =
                EventsTab().apply {
                    arguments = Bundle().apply {
                        putString(DAY, day)
                    }
                }
    }
}
