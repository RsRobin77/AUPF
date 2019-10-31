package com.daffodil.varsity.aupf.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.daffodil.varsity.aupf.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val ARG_TIME = "time"
private const val ARG_EVENT = "event"
private const val ARG_VENUE = "ic_venue"
private const val ARG_NAME = "name"
private const val ARG_PHONE = "phone"
private const val ARG_TEAM = "team"

class VolunteerDetailBottomSheet : BottomSheetDialogFragment() {
    private var time: String? = null
    private var event: String? = null
    private var venue: String? = null
    private var name: String? = null
    private var phone: String? = null
    private var team: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            time = it.getString(ARG_TIME)
            event = it.getString(ARG_EVENT)
            venue = it.getString(ARG_VENUE)
            name = it.getString(ARG_NAME)
            phone = it.getString(ARG_PHONE)
            team = it.getString(ARG_TEAM)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_volunteer_detail_bottom_sheet, container, false)
//        val mName: TextView = rootView.findViewById(R.id.name)
//        val mTime: TextView = rootView.findViewById(R.id.time)
//        val mVenue: TextView = rootView.findViewById(R.id.ic_venue)
//        val mEvent: TextView = rootView.findViewById(R.id.event)
//        val mPhone: TextView = rootView.findViewById(R.id.phone)
//        val mTeam: TextView = rootView.findViewById(R.id.team)
//
//        mName.text = name
//        mTime.text = time
//        mVenue.text = ic_venue
//        mEvent.text = event
//        mPhone.text = phone
//        mTeam.text = team

        return rootView
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param time Parameter 1.
         * @param event Parameter 2.
         * @return A new instance of fragment VolunteerDetailBottomSheet.
         */
        @JvmStatic
        fun newInstance(time: String, event: String, venue: String, name: String, phone: String, team: String) =
                VolunteerDetailBottomSheet().apply {
                    arguments = Bundle().apply {
                        putString(ARG_TIME, time)
                        putString(ARG_EVENT, event)
                        putString(ARG_VENUE, venue)
                        putString(ARG_NAME, name)
                        putString(ARG_PHONE, phone)
                        putString(ARG_TEAM, team)
                    }
                }
    }
}
