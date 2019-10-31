package com.daffodil.varsity.aupf.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.daffodil.varsity.aupf.R

/**
 * A simple [Fragment] subclass.
 */
class EventSegment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_segment, container, false)
    }


}
