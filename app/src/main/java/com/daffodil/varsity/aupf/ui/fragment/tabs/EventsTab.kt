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

        eventViewModel.getAllEvents().observe(this, Observer {
            val eventAdapter = EventAdapter()
            eventAdapter.submitList(it)
            val recyclerView = view!!.findViewById<RecyclerView>(R.id.recycler_view)

            recyclerView.apply {
                hasFixedSize()
                layoutManager = LinearLayoutManager(context)
                adapter = eventAdapter
            }
        })

        return inflater.inflate(R.layout.fragment_event_tabs, container, false)
    }
/*
    private fun eventsOf(day: String?) {
        when (day) {

            "day1" -> eventsOfDay1()

            "day2" -> eventsOfDay2()

            "day3" -> eventsOfDay3()

        }
    }

    private fun eventsOfDay1() {
        val day = "day1"

        eventViewModel.deleteAll(day)

        eventViewModel.insert(DailyEvent(day,
                "10:30 AM",
                "",
                "Arrival of the Guests",
                ""))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Project Showcase: ICT Carnival",
                "Field of Sadhinata Milanayoton"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Virtual Gaming Corner",
                "AB-4, Concourse"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Seminar-1: Cyber Security and Bangladesh",
                "AB-4, GraceHopper"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Mobile Apps Idea Contest 1",
                "202, 203, 204: 120"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Tech Debate-1: Why FB?",
                "504"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Alumni Dialogue 1",
                "502, 503"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Seminar -2: Bangla Computing",
                "AB-4, Nazrul"))

        eventViewModel.insert(DailyEvent(day,
                "12:30",
                "01:30",
                "Recess and Luncheon, Games Show",
                ""))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "02:40",
                "Motivation Session by Honorable Chairman",
                "Milanayoton Shadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "02:40",
                "03:30",
                "ICT Industry Career Dialogue-1",
                "Milanayoton Shadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Google Talk 1",
                "AB-4, Babbage-1"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Gaming Contest 1",
                "Lab-1, Lab 2, Lab-3, Lab-4, Lab-5, Lab-6"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Seminar-3: AI for Applications",
                "AB-4, GraceHopper"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Seminar-4: Smart Computing",
                "AB-4, Nazrul"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Alumni Dialogue 2",
                "502, 503"))

        eventViewModel.insert(DailyEvent(day,
                "03:00",
                "04:00",
                "Tech Fashion Show",
                "AB-4 Concourse"))

        eventViewModel.insert(DailyEvent(day,
                "03:30",
                "04:30",
                "Recreational movie 1: [Hackers 1995] + Musical show",
                "Milanayoton Shadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "03:00",
                "04:00",
                "Snacks and refreshments",
                ""))

        eventViewModel.insert(DailyEvent(day,
                "5:00",
                "",
                "Closing of Day 1",
                ""))


    }

    private fun eventsOfDay2() {
        val day = "day2"

        eventViewModel.deleteAll(day)

        eventViewModel.insert(DailyEvent(day,
                "10:00",
                "04:00",
                "Project Showcase: ICT Carnival",
                "SteveLounge"))

        eventViewModel.insert(DailyEvent(day,
                "10:00",
                "02:00",
                "Virtual Gaming Corner",
                "AB-4, Concourse"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Programming Contest",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Graphics Art Contest 2",
                "Lab-1, Lab 2, Lab-3, Lab-4"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "IT Olympiad-2",
                "AB-4, Babbage-1"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Business Idea Contest 2",
                "AB-4, VintCerf"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Security Challenges Contest 2",
                "Lab-5, Lab-6"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Seminar-5: Digital Bangladesh and Career",
                "AB-4, GraceHopper"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Mobile Apps Idea Contest 2",
                "202, 203, 204: 120"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Tech Debate-2: ICT Good for future?",
                "504"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Alumni Dialogue 3",
                "502, 503"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Seminar -6: IoT and Smart Campus",
                "AB-4, Nazrul"))

        eventViewModel.insert(DailyEvent(day,
                "12:30",
                "01:30",
                "Recess and Luncheon, Games Show",
                ""))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "02:40",
                "Parliamentary Debate by Faculty Members on “Quality Education using ICT”",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "02:40",
                "03:30",
                "ICT Industry Career Dialogue 2",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Google Talk 2",
                "AB-4, Babbage-1"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Motion Graphics Contest 1",
                "Lab-1, Lab 2, Lab-3, Lab-4, Lab-5, Lab-6"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Seminar-7: ICT Engaged Teaching",
                "AB-4, GraceHopper"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Seminar-8: Blockchain Computing",
                "AB-4, Nazrul"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Tech Debate-3: Robotic Society?",
                "504"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Alumni Dialogue 4",
                "502, 503: 80"))

        eventViewModel.insert(DailyEvent(day,
                "03:00",
                "04:00",
                "Tech Fashion Show",
                "AB-4 Concourse"))

        eventViewModel.insert(DailyEvent(day,
                "03:30",
                "04:30",
                "Recreational movie 2, [Takedown 2000] + TechMusic",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "03:00",
                "04:00",
                "Snacks and refreshments",
                ""))

        eventViewModel.insert(DailyEvent(day,
                "5:00",
                "",
                "Closing of Day 2",
                ""))


    }

    private fun eventsOfDay3() {
        val day = "day3"

        eventViewModel.deleteAll(day)

        eventViewModel.insert(DailyEvent(day,
                "10:00",
                "04:00",
                "Project Showcase: ICT Carnival",
                "SteveLounge"))

        eventViewModel.insert(DailyEvent(day,
                "10:00",
                "02:00",
                "Virtual Gaming Corner",
                "AB-4, Concourse"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Programming Contest 2",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "SEO Contest 1",
                "Rabindranath"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "IT Olympiad-3",
                "AB-4, Babbage-1, Babbage-2"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Tech Business Contest 1",
                "AB-4, VintCerf"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Graphics Design 2",
                "Lab-5, Lab-6"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Seminar-9: Applied Research and ICT",
                "AB-4, GraceHopper"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Mobile Apps Idea Contest 3",
                "202, 203, 204"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Student Mentor Student",
                "502, 503, 504"))

        eventViewModel.insert(DailyEvent(day,
                "11:00",
                "12:00",
                "Seminar -10: Next Generation Systems",
                "AB-4, Nazrul"))

        eventViewModel.insert(DailyEvent(day,
                "12:30",
                "01:30",
                "Recess and Luncheon, Games Show",
                ""))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "02:40",
                "Presentation by Daffodil Software",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "02:40",
                "03:30",
                "Students Voice",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Google Talk 3",
                "AB-4, Babbage-1"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Game Contest 3",
                "Lab-1, Lab 2, Lab-3, Lab-4, Lab-5, Lab-6"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Seminar-11: ICT Entrepreneur",
                "AB-4, GraceHopper"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Seminar-12: ICT Business Incubation",
                "AB-4, Nazrul"))

        eventViewModel.insert(DailyEvent(day,
                "02:00",
                "03:00",
                "Tech Debate-4: Future ICT Life?",
                "502, 503, 504"))

        eventViewModel.insert(DailyEvent(day,
                "03:30",
                "04:30",
                "Award and closing ceremony\n" +
                        "Cultural Show by the Cultural Club",
                "Milanayoton Sadhinata"))

        eventViewModel.insert(DailyEvent(day,
                "03:00",
                "04:00",
                "Snacks and refreshments",
                ""))

        eventViewModel.insert(DailyEvent(day,
                "5:00",
                "",
                "Closing of ICT Carnival",
                ""))

    }*/

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
