package com.daffodil.varsity.aupf.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffodil.varsity.aupf.R
import com.daffodil.varsity.aupf.adapter.EventSegmentAdapter
import com.daffodil.varsity.aupf.model.EventSegments

/**
 * A simple [Fragment] subclass.
 */
class EventSegment : Fragment() {
    private var eventSegments: List<EventSegments> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_event_segment, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.event_segment)

        recyclerView.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context)
            adapter = EventSegmentAdapter(eventSegments)
        }

        return rootView
    }

    init {
        eventSegments = listOf(
                EventSegments("30 September 2019", "Abstract Submission Deadline"),
                EventSegments("15 October 2019", "Paper Submission Deadline"),
                EventSegments("15 October 2019", "Registration Deadline"),
                EventSegments("November 22-24, 2019 ", "AUPF 2019")

        )
    }

}
